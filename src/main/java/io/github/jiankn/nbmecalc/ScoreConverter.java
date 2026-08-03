package io.github.jiankn.nbmecalc;

import java.util.Map;
import java.util.Objects;

/** Converts a single supported assessment into an internal equated score. */
public final class ScoreConverter {
    private static final Map<Integer, Integer> NBME_FORM_BIAS = Map.of(
            28, -3,
            29, -1,
            30, 0,
            31, 0,
            32, 1
    );

    private static final double[][] STEP_1_ANCHORS = {
            {200, 198}, {220, 215}, {240, 232}, {260, 245}, {280, 256}, {300, 264}
    };
    private static final double[][] STEP_2_ANCHORS = {
            {200, 218}, {220, 232}, {240, 248}, {260, 260}, {280, 270}, {300, 277}
    };
    private static final double[][] STEP_3_ANCHORS = {
            {200, 200}, {220, 213}, {240, 226}, {260, 240}, {280, 252}, {300, 260}
    };

    private ScoreConverter() { }

    /**
     * Converts one assessment using NBMEcalc model assumptions.
     * Values outside the outer anchor range are clamped to the nearest anchor.
     */
    public static int convert(PracticeExam exam, StepKind step) {
        Objects.requireNonNull(exam, "exam");
        Objects.requireNonNull(step, "step");

        return switch (exam.source()) {
            case NBME -> {
                int bias = exam.formNumber() == null
                        ? 0
                        : NBME_FORM_BIAS.getOrDefault(exam.formNumber(), 0);
                yield interpolate(anchors(step), exam.score() + bias);
            }
            case UWSA_1 -> interpolate(anchors(step), exam.score() - 5);
            case UWSA_2 -> interpolate(anchors(step), exam.score() - 2);
            case FREE_120 -> percentToEquated(exam.score(), step, false);
            case AMBOSS -> percentToEquated(exam.score(), step, true);
            case CMS -> exam.score() >= 150
                    ? interpolate(anchors(step), exam.score())
                    : percentToEquated(exam.score(), step, false);
        };
    }

    private static int percentToEquated(double percent, StepKind step, boolean amboss) {
        int baseAt75 = switch (step) {
            case STEP_1 -> 232;
            case STEP_2 -> 248;
            case STEP_3 -> 226;
        };
        double equated = baseAt75 + (percent - 75);
        if (amboss) {
            equated -= 5;
        }
        return (int) Math.round(equated);
    }

    private static double[][] anchors(StepKind step) {
        return switch (step) {
            case STEP_1 -> STEP_1_ANCHORS;
            case STEP_2 -> STEP_2_ANCHORS;
            case STEP_3 -> STEP_3_ANCHORS;
        };
    }

    private static int interpolate(double[][] anchors, double value) {
        if (value <= anchors[0][0]) {
            return (int) anchors[0][1];
        }
        if (value >= anchors[anchors.length - 1][0]) {
            return (int) anchors[anchors.length - 1][1];
        }
        for (int index = 0; index < anchors.length - 1; index++) {
            double[] lower = anchors[index];
            double[] upper = anchors[index + 1];
            if (value >= lower[0] && value <= upper[0]) {
                double ratio = (value - lower[0]) / (upper[0] - lower[0]);
                return (int) Math.round(lower[1] + ratio * (upper[1] - lower[1]));
            }
        }
        return (int) anchors[anchors.length - 1][1];
    }
}

