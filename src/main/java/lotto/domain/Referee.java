package lotto.domain;

import java.util.List;

public class Referee {
    private final WinningNumber winningNumber;

    public Referee(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningResult judgeRanks(List<Lotto> lottos) {
        WinningResult winningResult = new WinningResult();
        lottos.forEach(lotto -> winningResult.addRank(lotto.judgeRank(winningNumber)));
        return winningResult;
    }
}
