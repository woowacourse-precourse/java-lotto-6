package domain;

public class ProfitRate {

    private final double rate;

    public ProfitRate(long spendCost, long profitCost) {
        this.rate = calculateRate(spendCost, profitCost);
    }

    public double getRate() {
        return rate;
    }

    private static double calculateRate(long spendCost, long profitCost) {
        return (double) profitCost / spendCost*100;
    }
}
