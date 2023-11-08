package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int inputBonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumber(inputBonusNumber, winningNumbers);
        this.bonusNumber = inputBonusNumber;
    }

    private void validateBonusNumber(int inputBonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumberRange(inputBonusNumber);
        validateBonusNumberDuplicationWithWinningNumbers(inputBonusNumber, winningNumbers);
    }

    private void validateBonusNumberRange(int inputBonusNumber) {
        if (!isWithinRange(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_INVALID_ERROR.getMessage());
        }
    }

    private boolean isWithinRange(int inputBonusNumber) {
        return inputBonusNumber >= Constants.LOTTO_MIN_NUMBER && inputBonusNumber <= Constants.LOTTO_MAX_NUMBER;
    }

    private void validateBonusNumberDuplicationWithWinningNumbers(int inputBonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUM_AND_WINNING_NUM_DUPLICATE_ERROR.getMessage());
        }
    }

    public boolean equalsTo(int number) {
        return this.bonusNumber == number;
    }
}
