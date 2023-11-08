package lotto.domain;

import java.util.List;

public class WinningLottos {

    private final List<Integer> winningLottoCounts;

    public WinningLottos(List<Integer> winningLottoCounts) {
        this.winningLottoCounts = winningLottoCounts;
    }

    public double getPrize(Rank rank) {
        return winningLottoCounts.get(rank.getRankIndex()) * rank.getPrize();
    }

    public int getCount(int rankIndex) {
        return winningLottoCounts.get(rankIndex);
    }
}
