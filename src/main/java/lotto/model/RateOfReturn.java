package lotto.model;

public class RateOfReturn {
    public static final int PERCENT_MULTIPLIER = 100;
    private final double rate;

    private RateOfReturn(double rate) {
        this.rate = rate;
    }

    public static RateOfReturn calculate(double profit, double investmentAmount) {
        return new RateOfReturn(calculatePercentage(profit, investmentAmount));
    }

    private static double calculatePercentage(double numerator, double denominator) {
        return numerator / denominator * PERCENT_MULTIPLIER;
    }

    public double getRate() {
        return rate;
    }
}