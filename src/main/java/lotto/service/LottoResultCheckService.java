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
            List<Integer> issuedNumbers = lotto.getNumbers();
            boolean isMatchedBonusNumber = issuedNumbers.contains(bonus.getNumber());
            issuedNumbers.retainAll(winningLotto.getNumbers());
            Result result = new Result(issuedNumbers.size(), isMatchedBonusNumber);
            Ranking rankingOfLotto = result.checkRanking();
            //TODO: null이 들어왔을 때 처리할 방법도 고안해야 한다.
            results.add(rankingOfLotto);
        }
        return results;
    }

}
