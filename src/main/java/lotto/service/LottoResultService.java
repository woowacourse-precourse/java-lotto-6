package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultService {
    public LottoResult countMatchingNumbers(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        List<Integer> correctNumbers =  purchasedLotto.getLottos().stream()
                .map(winningLotto::countNumbers)
                .collect(Collectors.toList());

        Boolean isCorrectBonusNumber = purchasedLotto.getLottos().stream()
                .anyMatch(winningLotto::isCorrectBonusNumber);

        return new LottoResult(correctNumbers, isCorrectBonusNumber);
    }
}
