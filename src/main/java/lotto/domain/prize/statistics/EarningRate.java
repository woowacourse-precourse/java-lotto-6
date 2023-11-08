package lotto.domain.prize.statistics;

import lotto.domain.lotto.LottoPurchaseAmount;

public class EarningRate {
    private final LottoPurchaseAmount lottoPurchaseAmount;
    private final TotalPrizeAmount totalPrizeAmount;

    public EarningRate(
            final LottoPurchaseAmount lottoPurchaseAmount,
            final TotalPrizeAmount totalPrizeAmount
    ) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.totalPrizeAmount = totalPrizeAmount;
    }

    public double getEarningRate() {
        return (double) totalPrizeAmount.getAmount() / lottoPurchaseAmount.getAmount();
    }
}
