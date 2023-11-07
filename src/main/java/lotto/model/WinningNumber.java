package lotto.model;

import lotto.util.exception.DuplicatedLottoNumbersException;
import lotto.util.exception.NoWinningNumberException;

public class WinningNumber {
    private Lotto winningNumber;
    private int bonusNumber;

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningNumber == null) {
            throw new NoWinningNumberException();
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new DuplicatedLottoNumbersException();
        }
    }
}
