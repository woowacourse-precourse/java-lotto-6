package lotto.model;

public class ProfitRate {

    private static final int PERCENT_FACTOR = 100;

    private final float rate;

    public ProfitRate(
            final WinningProfit winningProfit,
            final PurchasePrice purchasePrice
    ) {
        this.rate = getProfitRate(winningProfit, purchasePrice);
    }

    public float getRate() {
        return rate;
    }

    private float getProfitRate(final WinningProfit winningProfit, final PurchasePrice purchasePrice) {
        return ((float) winningProfit.getProfit() / purchasePrice.getPrice()) * PERCENT_FACTOR;
    }

}
