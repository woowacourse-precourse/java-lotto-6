package lotto.model;

import lotto.utils.Constant;

import static lotto.utils.Constant.*;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
