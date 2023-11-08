package lotto.service;

import lotto.domain.*;

public class WinningService {

    public WinningScores calWinningScores(final Lottos lottos, final WinningNumbers winningNumbers, final BonusNumber bonusNumber){
        return lottos.calWinningScores(winningNumbers, bonusNumber);
    }

    public String getWinningScoresResult(final WinningScores winningScores){
        return winningScores.toString();
    }

    public double getReturnOfLottos(final WinningScores winningScores, final Budget budget){
        long lottosSum = winningScores.getWinningProfit();

        return budget.getProfit(lottosSum);
    }

}
