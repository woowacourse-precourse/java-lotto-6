package lotto.domain;

import java.util.List;

public class WinningLottoCounts {

    private final List<Integer> winningLottoCounts;

    public WinningLottoCounts(List<Lotto> myLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningLottoCounts = getWinningLottosCount(myLottos, winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningLottosCount(List<Lotto> myLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        WinningChecker winningChecker = new WinningChecker(myLottos, winningNumbers, bonusNumber);
        return winningChecker.countWinningLottos();
    }

    public double getPrize(Rank rank) {
        return winningLottoCounts.get(rank.getRankIndex()) * rank.getPrize();
    }

    public int getCount(int rankIndex) {
        return winningLottoCounts.get(rankIndex);
    }
}
