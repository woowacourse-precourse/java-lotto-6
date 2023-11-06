package lotto.service;

import lotto.domain.CorrectCount;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class WinningLottoCalculator {

    public CorrectCount calculate(WinningNumbers winningNumbers, Lotto lotto) {
        return new CorrectCount(
                winningNumbers.calculateWinningNumber(lotto),
                winningNumbers.calculateBonusNumber(lotto));
    }
}
