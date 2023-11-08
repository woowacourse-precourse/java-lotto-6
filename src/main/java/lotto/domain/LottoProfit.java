package lotto.domain;

public class LottoProfit {
    private static final double PERCENTAGE = 100.0;
    private final LottoPurchase lottoPurchase;
    private final RankResult rankResult;

    private LottoProfit(LottoPurchase lottoPurchase, RankResult rankResult) {
        this.lottoPurchase = lottoPurchase;
        this.rankResult = rankResult;
    }

    public static LottoProfit of(LottoPurchase lottoPurchase, RankResult rankResult) {
        return new LottoProfit(lottoPurchase, rankResult);
    }

    public double calculateProfitRate() {
        return (double) rankResult.calculateTotalWinnings() / lottoPurchase.getTotalAmount() * PERCENTAGE;
    }
}
