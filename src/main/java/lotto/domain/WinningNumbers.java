package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;

public class WinningNumbers {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if (hasDuplicateNumber(winningNumber, bonusNumber)) {
            throw new LottoGameException(ErrorMessage.DUPLICATE_INPUT);
        }
    }

    private boolean hasDuplicateNumber(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return winningNumber.getNumbers().contains(bonusNumber.getNumber());
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
