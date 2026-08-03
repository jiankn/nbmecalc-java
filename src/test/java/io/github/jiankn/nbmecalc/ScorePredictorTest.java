package io.github.jiankn.nbmecalc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScorePredictorTest {
    @Test
    void predictsSingleFreshInput() {
        Prediction result = ScorePredictor.predict(
                List.of(PracticeExam.nbme(240, 30, 0)),
                StepKind.STEP_2,
                5
        );
        assertEquals(248, result.pointEstimate());
        assertEquals(234, result.ciLower());
        assertEquals(262, result.ciUpper());
        assertEquals(Freshness.FRESH, result.freshness());
        assertEquals("v1.1", result.algorithmVersion());
    }

    @Test
    void widensLowQualityOnlyInputs() {
        Prediction result = ScorePredictor.predict(
                List.of(PracticeExam.amboss(70, 1)),
                StepKind.STEP_2
        );
        assertEquals(40, result.ciUpper() - result.ciLower());
        assertEquals(Freshness.UNKNOWN, result.freshness());
    }

    @Test
    void laterUndatedInputsReceiveMoreWeight() {
        Prediction result = ScorePredictor.predict(
                List.of(
                        PracticeExam.nbme(220, 30, null),
                        PracticeExam.nbme(260, 30, null)
                ),
                StepKind.STEP_2
        );
        assertTrue(result.pointEstimate() > 246);
        assertTrue(result.pointEstimate() < 260);
    }

    @Test
    void marksLongHorizonAsStaleAndBoundsProbability() {
        Prediction result = ScorePredictor.predict(
                List.of(PracticeExam.nbme(300, 30, 0)),
                StepKind.STEP_2,
                90
        );
        assertEquals(Freshness.STALE, result.freshness());
        assertTrue(result.passProbability() >= 0.01);
        assertTrue(result.passProbability() <= 0.99);
    }

    @Test
    void rejectsMissingInputsAndInvalidHorizon() {
        assertThrows(IllegalArgumentException.class,
                () -> ScorePredictor.predict(List.of(), StepKind.STEP_2));
        assertThrows(IllegalArgumentException.class,
                () -> ScorePredictor.predict(
                        List.of(PracticeExam.nbme(240, 30, 0)),
                        StepKind.STEP_2,
                        -1
                ));
    }
}

