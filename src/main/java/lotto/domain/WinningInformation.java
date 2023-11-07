package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.GameConfig.*;

public class WinningInformation {
    public static final int PERCENTAGE_MULTIPLIER = 100;
    private final Map<Rank, Integer> winningCount;
    private final int lottoCount;

    private WinningInformation(Map<Rank, Integer> winningCount, Integer lottoCount) {
        this.winningCount = winningCount;
        this.lottoCount = lottoCount;
    }

    public static WinningInformation of(List<Rank> ranks) {
        Map<Rank, Integer> winningCount = convertRankListToMap(ranks);
        return new WinningInformation(winningCount, ranks.size());
    }

    public Map<Rank, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCount);
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
        for (Rank rank : Rank.values()) {
            profit += rank.getPrize() * winningCount.get(rank);
        }
        return profit;
    }

    private static Map<Rank, Integer> convertRankListToMap(List<Rank> ranks) {
        Map<Rank, Integer> winningCount = new HashMap<>();

        ranks.forEach((rank) -> {
            int currentWinningCount = winningCount.getOrDefault(rank, 0);
            winningCount.put(rank, currentWinningCount + 1);
        });
        return winningCount;
    }
}
