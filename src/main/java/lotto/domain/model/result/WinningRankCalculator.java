package lotto.domain.model.result;

import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.lotto.LottoWinningNumbers;

public class WinningRankCalculator {

    public WinningRank determineWinningRank(Lotto lotto, LottoWinningNumbers lottoWinningNumbers) {
        int countOfMatchingNumbers = lotto.countMatchingNumbers(lottoWinningNumbers.getWinningNumbers());
        boolean isBonusMatched = lotto.contains(lottoWinningNumbers.getBonusNumber());
        return WinningRank.from(countOfMatchingNumbers, isBonusMatched);
    }
}
