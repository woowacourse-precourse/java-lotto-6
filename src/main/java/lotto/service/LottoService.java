package lotto.service;

import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.domain.WinningScores;

public class LottoService {

    public Lottos createLottos(Budget budget){
        return Lottos.createLottos(budget);
    }

    public int getLottosSize(Lottos lottos){
        return lottos.getLottosSize();
    }

    public String getLottosNumbers(Lottos lottos){
        return lottos.getLottosNumbers();
    }

    public double getReturnOfLottos(WinningScores winningScores, Budget budget){
        long lottosSum = winningScores.getWinningProfit();

        return budget.getProfit(lottosSum);
    }
}
