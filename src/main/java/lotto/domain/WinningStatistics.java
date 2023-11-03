package lotto.domain;

import java.util.Map;

public class WinningStatistics {
    private Map<Rank, Integer> rankCount;
    private double profitRate;

    public WinningStatistics(Map<Rank, Integer> rankCount, double profitRate) {
        this.rankCount = Map.copyOf(rankCount);
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
