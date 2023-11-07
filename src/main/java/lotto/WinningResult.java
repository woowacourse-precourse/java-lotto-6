package lotto;

import java.util.Map;

public record WinningResult(Map<Rank, Integer> winningStatistics, Double winningRate) {

    private static final Integer INCREASE_COUNT = 1;

    public void add(Rank rank) {
        winningStatistics.put(rank, getCount(rank) + INCREASE_COUNT);
    }

    private int getCount(Rank rank) {
        return winningStatistics.get(rank);
    }
}