package lotto.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;

public class LottoResults {
    private static final int ONE = 1;
    private static final int MULTIPLYING_NUMBER = 100;

    private final List<LottoRank> elements;
    private final LottoPurchaseCost lottoPurchaseCost;

    public LottoResults(List<LottoRank> elements, LottoPurchaseCost lottoPurchaseCost) {
        this.elements = elements;
        this.lottoPurchaseCost = lottoPurchaseCost;
    }

    private static Map<LottoRank, Integer> initRankCounts() {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        List<LottoRank> winningRanks = LottoRank.getWinningRanks();
        winningRanks.forEach(rank -> rankCounts.put(rank, 0));

        return rankCounts;
    }

    private long getWinningSum() {
        return elements.stream()
                .map(LottoRank::getWinnings)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public Map<LottoRank, Integer> getRankCounts() {
        Map<LottoRank, Integer> rankCounts = initRankCounts();

        elements.forEach(rank -> {
            int increasedCount = rankCounts.get(rank) + ONE;
            rankCounts.put(rank, increasedCount);
        });

        return rankCounts;
    }

    public double getRateOfReturn() {
        double winningSum = Long.valueOf(getWinningSum()).doubleValue();
        return winningSum / lottoPurchaseCost.getCost() * MULTIPLYING_NUMBER;
    }
}
