package lotto.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private static final int DEFAULT = 0;

    private Map<Rank, Integer> winningRankAndCounting;

    public Result() {
        this.winningRankAndCounting = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            winningRankAndCounting.put(rank, DEFAULT);
        }
    }

    public void calculateWinningResult(RandomLottos randomLottos, WinningLotto winningLotto, Bonus bonus) {
        for (Lotto randomLotto : randomLottos.getRandomLottos()) {
            Rank rank = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
            winningRankAndCounting.put(rank, winningRankAndCounting.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getWinningRankAndCounting() {
        return winningRankAndCounting;
    }

    public int calculateTotalWinningPrize() {
        int winningPrize = DEFAULT;
        for (Rank rank : winningRankAndCounting.keySet()) {
            if (hasWinningCounts(getWinningCountsFrom(rank))) {
                winningPrize += Rank.getPrize(rank) * getWinningCountsFrom(rank);
            }
        }
        return winningPrize;
    }

    private int getWinningCountsFrom(Rank rank) {
        return winningRankAndCounting.get(rank);
    }

    private boolean hasWinningCounts(int winningCounts) {
        return winningCounts != DEFAULT;
    }
}
