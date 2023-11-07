package lotto.Model;

import static lotto.Constants.DEFAULT;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> winningRankAndCounting;

    public Result() {
        this.winningRankAndCounting = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            winningRankAndCounting.put(rank, DEFAULT);
        }
    }

    public void makeWinningResultWith(RandomLottos randomLottos, WinningLotto winningLotto, Bonus bonus) {
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
            if (isNotDefault(getWinningCountingFrom(rank))) {
                winningPrize += Rank.getPrize(rank) * getWinningCountingFrom(rank);
            }
        }
        return winningPrize;
    }

    private int getWinningCountingFrom(Rank rank) {
        return winningRankAndCounting.get(rank);
    }

    private boolean isNotDefault(int winningCounts) {
        return winningCounts != DEFAULT;
    }
}
