package lotto.model;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(int revenue, int purchaseAmount) {
        this.profitRate = ((double) revenue / purchaseAmount) * 100;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
