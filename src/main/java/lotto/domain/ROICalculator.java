package lotto.domain;

public final class ROICalculator {

    private static final double DECIMAL_ROUNDING_FACTOR = 100.0;

    public double calculate(long totalPrize, long investment) {
        double rawROI = computeRawROI(totalPrize, investment);
        return roundToSecondDecimal(rawROI);
    }

    private double computeRawROI(long totalPrize, long investment) {
        return (double) totalPrize / investment;
    }

    private double roundToSecondDecimal(double value) {
        return Math.round(value * DECIMAL_ROUNDING_FACTOR) / DECIMAL_ROUNDING_FACTOR;
    }
}
