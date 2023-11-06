package lotto.model.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.domain.LottoResult;
import lotto.model.domain.WinningNumber;

public class LottoChecker {

    public LottoResult findWinningLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            lottoResult.addResult(checkLotto(lotto, winningNumber));
        }

        return lottoResult;
    }

    private LottoRank checkLotto(Lotto lotto, WinningNumber winningNumber) {
        int correct = 0;
        boolean hasBonus = false;

        for (Integer number : winningNumber.getNumbers()) {
            if (lotto.containsNumber(number)) {
                correct++;
            }
        }

        if (lotto.containsNumber(winningNumber.getBonusNumber())) {
            hasBonus = true;
        }

        return LottoRank.findRank(correct, hasBonus);
    }

}
