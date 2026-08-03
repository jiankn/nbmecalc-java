package io.github.jiankn.nbmecalc;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Combines converted practice assessments into a weighted educational estimate. */
public final class ScorePredictor {
    /** Calculation rules shared with the NBMEcalc web baseline at extraction time. */
    public static final String ALGORITHM_VERSION = "v1.1";

    private static final Map<AssessmentSource, Double> SOURCE_QUALITY = Map.of(
            AssessmentSource.NBME, 1.0,
            AssessmentSource.UWSA_1, 0.85,
            AssessmentSource.UWSA_2, 1.0,
            AssessmentSource.FREE_120, 1.0,
            AssessmentSource.AMBOSS, 0.75,
            AssessmentSource.CMS, 0.6
    );

    private ScorePredictor() { }

    /** Predicts without an examination-date adjustment. */
    public static Prediction predict(List<PracticeExam> exams, StepKind step) {
        return predict(exams, step, null);
    }

    /**
     * Combines one or more inputs using recency and source-quality weights.
     *
     * @param exams non-empty list of practice assessments
     * @param step requested Step family
     * @param daysUntilExam optional non-negative number of days until the examination
     * @return bounded point estimate, uncertainty interval, and model pass probability
     */
    public static Prediction predict(List<PracticeExam> exams, StepKind step, Integer daysUntilExam) {
        Objects.requireNonNull(exams, "exams");
        Objects.requireNonNull(step, "step");
        if (exams.isEmpty()) {
            throw new IllegalArgumentException("at least one practice exam is required");
        }
        if (daysUntilExam != null && daysUntilExam < 0) {
            throw new IllegalArgumentException("daysUntilExam must be non-negative");
        }

        double weightedTotal = 0;
        double totalWeight = 0;
        boolean onlyLowQuality = true;

        for (int index = 0; index < exams.size(); index++) {
            PracticeExam exam = Objects.requireNonNull(exams.get(index), "exam");
            double sourceQuality = SOURCE_QUALITY.get(exam.source());
            onlyLowQuality &= sourceQuality < 0.85;
            double recencyWeight = exam.takenDaysAgo() == null
                    ? Math.pow(1.15, index)
                    : Math.exp(-exam.takenDaysAgo() / 30.0);
            double weight = recencyWeight * sourceQuality;
            weightedTotal += ScoreConverter.convert(exam, step) * weight;
            totalWeight += weight;
        }

        int point = (int) Math.round(weightedTotal / totalWeight);
        double rawHalfWidth = 16.0 / Math.sqrt(exams.size());
        if (onlyLowQuality) {
            rawHalfWidth *= 1.25;
        }

        Freshness freshness = Freshness.UNKNOWN;
        if (daysUntilExam != null) {
            if (daysUntilExam <= 7) {
                rawHalfWidth *= 0.85;
                freshness = Freshness.FRESH;
            } else if (daysUntilExam > 60) {
                rawHalfWidth *= 1.2;
                freshness = Freshness.STALE;
            } else {
                freshness = Freshness.FRESH;
            }
        }

        int halfWidth = Math.max(3, (int) Math.round(rawHalfWidth));
        double probability = passProbability(point, step, halfWidth);
        return new Prediction(
                step,
                point,
                point - halfWidth,
                point + halfWidth,
                probability,
                exams.size(),
                freshness,
                ALGORITHM_VERSION
        );
    }

    private static double passProbability(int point, StepKind step, int halfWidth) {
        int threshold = switch (step) {
            case STEP_1 -> 196;
            case STEP_2 -> 218;
            case STEP_3 -> 198;
        };
        double sigma = Math.max(8, halfWidth * 0.7);
        double z = (point - threshold) / sigma;
        double raw = 1 / (1 + Math.exp(-z));
        return Math.min(0.99, Math.max(0.01, raw));
    }
}

