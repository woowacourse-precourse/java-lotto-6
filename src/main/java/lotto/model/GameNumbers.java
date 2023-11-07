package lotto.model;

import lotto.constant.ErrorMessage;

public class GameNumbers {

    private final WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public GameNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void addBonusNumber(BonusNumber bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(BonusNumber bonusNumber) {
        if (winningNumbers.containNumber(bonusNumber.toInt())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.getErrorMessage());
        }
    }
}
