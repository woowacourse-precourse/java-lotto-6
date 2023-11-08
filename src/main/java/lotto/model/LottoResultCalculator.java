package lotto.model;

import java.util.List;


public class LottoResultCalculator {
    public static LottoResult calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult(winningNumbers);
        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.countMatchNumbers(lotto);
            boolean hasBonusNumber = winningNumbers.hasBonusNumber(lotto);
            lottoResult.addResult(matchCount, hasBonusNumber);
        }
        return lottoResult;
    }
}
