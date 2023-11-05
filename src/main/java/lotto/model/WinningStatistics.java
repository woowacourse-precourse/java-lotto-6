package lotto.model;

import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }
}
