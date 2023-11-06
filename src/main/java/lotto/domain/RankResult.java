package lotto.domain;

import static lotto.domain.NumberConstant.FOR_PERCENT;

import java.util.Arrays;
import java.util.Map;

public class RankResult {
    private final Map<RankPrize, Integer> rankResult;

    public RankResult(Map<RankPrize, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public Map<RankPrize, Integer> getRankResult() {
        return this.rankResult;
    }

    public double calculateReturn(int parsedPurchaseAmount) {
        double totalAmount = getTotalAmount();
        return totalAmount / parsedPurchaseAmount * FOR_PERCENT.getValue();
    }

    private double getTotalAmount() {
        return Arrays.stream(RankPrize.values())
                .mapToDouble(rankPrize -> rankPrize.getPrizeAmount() * this.getWinCounts(rankPrize))
                .sum();
    }

    private int getWinCounts(RankPrize rankPrize) {
        return this.rankResult.get(rankPrize);
    }
}
