package lotto.model;

public class ReturnCalculator {
    private static final int PERCENTAGE_MULTIPLIER = 1000;
    private static final double ROUNDING_PRECISION = 10.0;

    public double calculateRateOfReturn(double rateOfReturn) {
        rateOfReturn = roundToPrecision(rateOfReturn);
        rateOfReturn *= PERCENTAGE_MULTIPLIER;
        return rateOfReturn;
    }

    private double roundToPrecision(double value) {
        return Math.round(value * ROUNDING_PRECISION) / ROUNDING_PRECISION;
    }
}
