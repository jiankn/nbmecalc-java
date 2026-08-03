package io.github.jiankn.nbmecalc;

import java.util.Objects;

/**
 * One practice-assessment input.
 *
 * @param source assessment family
 * @param score native score: three-digit for NBME/UWSA, percentage for Free 120/AMBOSS,
 *              and percentage or three-digit for CMS
 * @param formNumber optional NBME form number
 * @param takenDaysAgo optional non-negative age in days
 */
public record PracticeExam(
        AssessmentSource source,
        double score,
        Integer formNumber,
        Integer takenDaysAgo
) {
    public PracticeExam {
        Objects.requireNonNull(source, "source");
        if (!Double.isFinite(score)) {
            throw new IllegalArgumentException("score must be finite");
        }
        if (takenDaysAgo != null && takenDaysAgo < 0) {
            throw new IllegalArgumentException("takenDaysAgo must be non-negative");
        }
    }

    public static PracticeExam nbme(double score, Integer formNumber, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.NBME, score, formNumber, takenDaysAgo);
    }

    public static PracticeExam uwsa1(double score, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.UWSA_1, score, null, takenDaysAgo);
    }

    public static PracticeExam uwsa2(double score, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.UWSA_2, score, null, takenDaysAgo);
    }

    public static PracticeExam free120(double percent, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.FREE_120, percent, null, takenDaysAgo);
    }

    public static PracticeExam amboss(double percent, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.AMBOSS, percent, null, takenDaysAgo);
    }

    public static PracticeExam cms(double score, Integer takenDaysAgo) {
        return new PracticeExam(AssessmentSource.CMS, score, null, takenDaysAgo);
    }
}

