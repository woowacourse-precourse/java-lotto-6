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
        double rateOfReturn = (double) totalIncome / money * 100;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        return rateOfReturn;
    }
}
