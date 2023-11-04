package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public class RankResult {
    public static final double ZERO = 0d;
    private final Map<RankPrize, Integer> rankResult;

    public RankResult(Map<RankPrize, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public int getWinCounts(RankPrize rankPrize) {
        return this.rankResult.get(rankPrize);
    }

    public double calculateReturn() {
        double totalAmount = getTotalAmount();
        double totalCounts = getTotalCounts();
        if (totalCounts == ZERO) {
            return ZERO;
        }
        return totalAmount / totalCounts;
    }

    private double getTotalAmount() {
        return Arrays.stream(RankPrize.values())
                .mapToDouble(rankPrize -> rankPrize.getPrizeAmount() * this.getWinCounts(rankPrize))
                .sum();
    }

    private double getTotalCounts() {
        return Arrays.stream(RankPrize.values())
                .mapToDouble(this::getWinCounts)
                .sum();
    }
}
