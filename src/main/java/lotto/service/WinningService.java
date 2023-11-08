package lotto.service;

import lotto.domain.*;

public class WinningService {

    public WinningScores calWinningScores(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber){
        return lottos.calWinningScores(winningNumbers, bonusNumber);
    }

    public String getWinningScoresResult(WinningScores winningScores){
        return winningScores.toString();
    }

    public double getReturnOfLottos(WinningScores winningScores, Budget budget){
        long lottosSum = winningScores.getWinningProfit();

        return budget.getProfit(lottosSum);
    }

}
