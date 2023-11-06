package lotto.service;

import java.util.Map;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.utils.Prize;

public class PrizeManager {
    private final Map<Prize, Integer> prizesCount;

    public PrizeManager(Map<Prize, Integer> prizesCount) {
        this.prizesCount = prizesCount;
    }

    public int getPrizeCount(Prize prize) {
        return prizesCount.get(prize);
    }

    public double getProfitRate(PurchaseAmout purchaseAmout) {
        return purchaseAmout.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : prizesCount.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * prizesCount.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
