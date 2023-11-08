package lotto.Model;

import static lotto.Constants.DEFAULT;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> countByWinningRank;

    public Result() {
        this.countByWinningRank = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            countByWinningRank.put(rank, DEFAULT);
        }
    }

    public void countWinningRank(RandomLottos randomLottos, WinningLotto winningLotto, Bonus bonus) {
        for (Lotto randomLotto : randomLottos.getRandomLottos()) {
            Rank rank = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
            updateWinningRank(rank);
        }
    }

    public Map<Rank, Integer> getCountByWinningRank() {
        return countByWinningRank;
    }

    public int calculateTotalPrize() {
        int prize = DEFAULT;
        for (Rank rank : countByWinningRank.keySet()) {
            if (!isDefault(getCount(rank))) {
                prize += Rank.getPrize(rank) * getCount(rank);
            }
        }
        return prize;
    }

    private void updateWinningRank(Rank rank) {
        countByWinningRank.put(rank, countByWinningRank.get(rank) + 1);
    }

    private int getCount(Rank rank) {
        return countByWinningRank.get(rank);
    }

    private boolean isDefault(int winningCounts) {
        return winningCounts == DEFAULT;
    }
}
