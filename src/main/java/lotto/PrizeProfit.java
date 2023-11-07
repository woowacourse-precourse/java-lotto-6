package lotto;

public class PrizeProfit {
    private final double rate;

    public PrizeProfit(PrizeStats prizeStats, long buyingPrice) {
        long prizeMoney = calculatePrizeMoney(prizeStats);
        this.rate = (double) prizeMoney / buyingPrice;
    }

    public double getRate() {
        return this.rate;
    }
}
