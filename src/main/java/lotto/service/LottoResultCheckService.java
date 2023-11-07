package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Bonus;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.Ranking;
import lotto.model.domain.Result;
import lotto.model.domain.WinningLotto;

public class LottoResultCheckService {

    public List<Ranking> checkResult(LottoMachine lottoMachine, WinningLotto winningLotto, Bonus bonus) {
        List<Ranking> results = new ArrayList<>();
        for(Lotto lotto : lottoMachine.getIssuedLotto()) {
            Result result = getCommonResult(lotto, winningLotto, bonus);
            Ranking rankingOfLotto = result.checkRanking();
            results.add(rankingOfLotto);
        }
        return results;
    }

    private Result getCommonResult(Lotto lotto, WinningLotto winningLotto, Bonus bonus) {
        boolean isMatchedBonusNumber = lotto.containBonusNumber(bonus.getNumber());
        int resultSize = lotto.removeNonCommonNumber(winningLotto.getNumbers());
        return new Result(resultSize, isMatchedBonusNumber);
    }

}
