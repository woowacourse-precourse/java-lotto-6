package lotto;

import java.util.Map;

public record WinningResult(Map<Rank, Integer> winningStatistics, Double winningRate) {

    public void add(Rank rank) {
        winningStatistics.put(rank, getCount(rank) + 1);
    }

    private int getCount(Rank rank) {
        return winningStatistics.get(rank);
    }
}