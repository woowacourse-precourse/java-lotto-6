package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;

public class NumberMatchController {
    private int getMatchedNumbersCount(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumber::isWinningNumbersMatched)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, WinningNumber winningNumber) {
        return winningNumber.hasBonusNumber(lotto.getNumbers());
    }

    public void matchAllLottos(Lottos lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            lottos.addWinningCount(getMatchedNumbersCount(lotto, winningNumber));
            lottos.checkBonusNumberMatched(hasBonusNumber(lotto, winningNumber));
        }
    }
}
