package lotto.model;

public class ProfitRate {

    private static final int FOR_RATE = 100;

    private double profitRate;

    public double getProfitRate() {
        return profitRate;
    }

    public void calculate(double reward, double purchaseAmount) {
        profitRate = reward / purchaseAmount * FOR_RATE;
    }
}
