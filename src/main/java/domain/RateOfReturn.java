package domain;

public class RateOfReturn {
    private final double rate;

    public RateOfReturn(long totalIncome, long money) {
        this.rate = calculateRateOfReturn(totalIncome, money);
    }

    public double getRate() {
        return rate;
    }

    private static double calculateRateOfReturn(long totalIncome, long money) {
        return (double) totalIncome / money * 100;
    }
}
