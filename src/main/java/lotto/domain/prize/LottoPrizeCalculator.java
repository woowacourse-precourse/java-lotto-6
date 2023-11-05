package lotto.domain.prize;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;

public class LottoPrizeCalculator {

    public LottoPrizeCalculator() {
    }

    public LottoPrizeType calculatePrize(LottoWinningNumbers winningNumbers, Lotto lotto) {
        return LottoPrizeType.toPrizeType(
                winningNumbers.calculateWinningNumberCount(lotto),
                winningNumbers.matchesBonusNumber(lotto)
        );
    }

}
