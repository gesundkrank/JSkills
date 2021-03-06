package de.gesundkrank.jskills.elo;

import de.gesundkrank.jskills.PairwiseComparison;

import org.junit.Test;

public class GaussianEloCalculatorTest {
    @Test
    public void gaussianEloCalculatorTests() {
        final double defaultKFactor = 24.0;
        GaussianEloCalculator calc = new GaussianEloCalculator();

        EloAssert.assertChessRating(calc, 1200, 1200, PairwiseComparison.WIN, 1212, 1188);
        EloAssert.assertChessRating(calc, 1200, 1200, PairwiseComparison.DRAW, 1200, 1200);
        EloAssert.assertChessRating(calc, 1200, 1200, PairwiseComparison.LOSE, 1188, 1212);

        // verified using TrueSkill paper equation
        EloAssert.assertChessRating(calc, 1200, 1000, PairwiseComparison.WIN, 1200 + ((1 - 0.76024993890652326884) * defaultKFactor), 1000 - (1 - 0.76024993890652326884) * defaultKFactor);
        EloAssert.assertChessRating(calc, 1200, 1000, PairwiseComparison.DRAW, 1200 - (0.76024993890652326884 - 0.5) * defaultKFactor, 1000 + (0.76024993890652326884 - 0.5) * defaultKFactor);
        EloAssert.assertChessRating(calc, 1200, 1000, PairwiseComparison.LOSE, 1200 - 0.76024993890652326884 * defaultKFactor, 1000 + 0.76024993890652326884 * defaultKFactor);
    }               
}