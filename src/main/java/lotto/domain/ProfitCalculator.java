package lotto.domain;

import java.util.Map;

public class ProfitCalculator {
    private final Map<Prize, Integer> lottosResult;

    public ProfitCalculator(Map<Prize, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public long getTotalProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : lottosResult.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * lottosResult.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
