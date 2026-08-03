package io.github.jiankn.nbmecalc;

/**
 * Uncertainty-aware educational score estimate.
 *
 * @param step requested Step family
 * @param pointEstimate weighted point estimate
 * @param ciLower lower uncertainty bound
 * @param ciUpper upper uncertainty bound
 * @param passProbability bounded model probability from 0.01 to 0.99
 * @param inputCount number of practice assessments used
 * @param freshness timing label derived from days until the examination
 * @param algorithmVersion compatibility identifier for the calculation rules
 */
public record Prediction(
        StepKind step,
        int pointEstimate,
        int ciLower,
        int ciUpper,
        double passProbability,
        int inputCount,
        Freshness freshness,
        String algorithmVersion
) { }

