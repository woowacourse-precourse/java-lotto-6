package lotto.domain;

import java.util.*;

import static lotto.configuration.GameConfig.*;

public class WinningInformation {
    public static final int PERCENTAGE_MULTIPLIER = 100;
    private final Map<Rank, Integer> winningCounts;
    private final int lottoCount;

    private WinningInformation(Map<Rank, Integer> winningCounts, Integer lottoCount) {
        this.winningCounts = winningCounts;
        this.lottoCount = lottoCount;
    }

    public static WinningInformation of(List<Rank> ranks) {
        Map<Rank, Integer> winningCount = convertRankListToMap(ranks);
        return new WinningInformation(winningCount, ranks.size());
    }

    public Map<Rank, Integer> getWinningCounts() {
        return Collections.unmodifiableMap(winningCounts);
    }

    public double getProfitability() {
        float profit = calculateProfit();
        float cost = lottoCount * PURCHASE_MONEY_UNIT;

        return calculatePercentage(profit, cost);
    }

    private static double calculatePercentage(float profit, float cost) {
        return (profit / cost) * PERCENTAGE_MULTIPLIER;
    }

    private float calculateProfit() {
        float profit = 0;
        for (Rank rank : winningCounts.keySet()) {
            profit += rank.getPrize() * winningCounts.get(rank);
        }

        return profit;
    }

    private static Map<Rank, Integer> convertRankListToMap(List<Rank> ranks) {
        Map<Rank, Integer> winningCounts = new HashMap<>();

        for (Rank rankValue : Rank.values()) {
            int currentRankCount = (int) ranks.stream()
                    .filter(rank -> rank == rankValue)
                    .count();
            winningCounts.put(rankValue, currentRankCount);
        }

        return winningCounts;
    }
}
