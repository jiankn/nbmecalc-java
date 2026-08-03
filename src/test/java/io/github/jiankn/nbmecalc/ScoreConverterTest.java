package io.github.jiankn.nbmecalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreConverterTest {
    @Test
    void interpolatesStepTwoNbmeAnchors() {
        assertEquals(218, ScoreConverter.convert(PracticeExam.nbme(200, 30, 0), StepKind.STEP_2));
        assertEquals(248, ScoreConverter.convert(PracticeExam.nbme(240, 30, 0), StepKind.STEP_2));
        assertEquals(277, ScoreConverter.convert(PracticeExam.nbme(300, 30, 0), StepKind.STEP_2));
        assertEquals(240, ScoreConverter.convert(PracticeExam.nbme(230, 30, 0), StepKind.STEP_2));
    }

    @Test
    void appliesKnownNbmeFormBias() {
        int form28 = ScoreConverter.convert(PracticeExam.nbme(240, 28, 0), StepKind.STEP_2);
        int form32 = ScoreConverter.convert(PracticeExam.nbme(240, 32, 0), StepKind.STEP_2);
        assertEquals(246, form28);
        assertEquals(249, form32);
    }

    @Test
    void appliesUwsaAndAmbossAdjustments() {
        assertEquals(251, ScoreConverter.convert(PracticeExam.uwsa1(250, 0), StepKind.STEP_2));
        assertEquals(253, ScoreConverter.convert(PracticeExam.uwsa2(250, 0), StepKind.STEP_2));
        assertEquals(248, ScoreConverter.convert(PracticeExam.free120(75, 0), StepKind.STEP_2));
        assertEquals(243, ScoreConverter.convert(PracticeExam.amboss(75, 0), StepKind.STEP_2));
    }

    @Test
    void treatsCmsAsPercentageOrThreeDigitSignal() {
        assertEquals(248, ScoreConverter.convert(PracticeExam.cms(75, 0), StepKind.STEP_2));
        assertEquals(248, ScoreConverter.convert(PracticeExam.cms(240, 0), StepKind.STEP_2));
    }

    @Test
    void rejectsNonFiniteScoresAndNegativeAge() {
        assertThrows(IllegalArgumentException.class,
                () -> PracticeExam.free120(Double.NaN, 0));
        assertThrows(IllegalArgumentException.class,
                () -> PracticeExam.nbme(240, 30, -1));
    }
}

