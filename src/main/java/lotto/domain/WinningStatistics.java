package lotto.domain;

import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningCount;
    private final double profitRate;

    public WinningStatistics(Map<Rank, Integer> winningCount, double profitRate) {
        this.winningCount = winningCount;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getWinningCount() {
        return winningCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
