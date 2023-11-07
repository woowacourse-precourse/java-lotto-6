package lotto;

import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;
    private final Double winningRate;

    public WinningResult(Map<Rank, Integer> winningResult, Double winningRate) {
        this.winningResult = winningResult;
        this.winningRate = winningRate;
    }

    public void add(Rank rank) {
        winningResult.put(rank, getCount(rank) + 1);
    }

    private int getCount(Rank rank) {
        return winningResult.get(rank);
    }

    public Map<Rank, Integer> getWinningResult() {
        return winningResult;
    }

    public Double getWinningRate() {
        return winningRate;
    }
}
