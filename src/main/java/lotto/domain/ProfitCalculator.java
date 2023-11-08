package lotto.domain;

import java.util.Map;

public class ProfitCalculator {
    private final Map<Prize, Integer> winningResult;

    public ProfitCalculator(Map<Prize, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public long getTotalProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : winningResult.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * winningResult.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
