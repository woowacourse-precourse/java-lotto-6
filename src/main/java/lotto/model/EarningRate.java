package lotto.model;


public class EarningRate {
    private final double earningRate;

    public EarningRate(double totalPrize, LottoAmount amount) {
        this.earningRate = calculateEarningRate(totalPrize, amount.getAmount());
    }

    public double getEarningRate() {
        return earningRate;
    }

    private double calculateEarningRate(double totalPrize, int purchaseAmount) {
        return Math.round((totalPrize / purchaseAmount) * 100 * 100) / 100.0;
    }
}
