package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Ranking;
import lotto.model.Result;
import lotto.model.WinningNumber;

public class LottoResultCheckService {

    public List<Ranking> checkResult(LottoMachine lottoMachine, WinningNumber winningNumber, Bonus bonus) {
        List<Ranking> results = new ArrayList<>();
        for (Lotto lotto : lottoMachine.getIssuedLotto()) {
            Result result = getCommonResult(lotto, winningNumber, bonus);
            Ranking rankingOfLotto = result.checkRanking();
            results.add(rankingOfLotto);
        }
        return results;
    }

    Result getCommonResult(Lotto lotto, WinningNumber winningNumber, Bonus bonus) {
        boolean isMatchedBonusNumber = lotto.containBonusNumber(bonus.getNumber());
        int resultSize = lotto.removeNonCommonNumber(winningNumber.getNumbers());
        return new Result(resultSize, isMatchedBonusNumber);
    }

}
