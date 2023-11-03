package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResultService {
    public List<LottoResult> countMatchingNumbers(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : purchasedLotto.getLottos()) {
            Integer correctNumbers = winningLotto.countNumbers(lotto);

            Boolean isCorrectBonusNumber = winningLotto.isCorrectBonusNumber(lotto);

            lottoResults.add(new LottoResult(correctNumbers, isCorrectBonusNumber));
        }

        return lottoResults;
    }
}
