package lotto.domain;

import java.util.Map;
import lotto.domain.wrapper.PurchaseAmount;

public class ProfitCalculator {
    private final Map<Prize, Integer> lottosResult;

    public ProfitCalculator(Map<Prize, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public double getProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : lottosResult.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * lottosResult.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
