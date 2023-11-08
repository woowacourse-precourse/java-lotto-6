package domain;

public class ProfitRate {

    private final double rate;

    public ProfitRate(long spendCost, long profitCost) {
        this.rate = calculateRateOfReturn(spendCost, profitCost);
    }

    public double getRate() {
        return rate;
    }

    private static double calculateRateOfReturn(long spendCost, long profitCost) {
        return (double) profitCost / spendCost*100;
    }
}
