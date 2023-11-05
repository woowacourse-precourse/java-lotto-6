package lotto.domain;

public final class ROICalculator {

    private static final double DECIMAL_ROUNDING_FACTOR = 10.0;

    public double calculate(long totalPrize, long investment) {
        double rawROI = computeRawROI(totalPrize, investment);
        return roundToFirstDecimal(rawROI);
    }

    private double computeRawROI(long totalPrize, long investment) {
        return (double) totalPrize / investment;
    }

    private double roundToFirstDecimal(double value) {
        return Math.round(value * DECIMAL_ROUNDING_FACTOR) / DECIMAL_ROUNDING_FACTOR;
    }
}
