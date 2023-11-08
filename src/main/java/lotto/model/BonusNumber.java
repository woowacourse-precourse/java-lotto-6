package lotto.model;

import lotto.enums.Bounds;
import lotto.enums.Message;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumberIsNumber(bonusNumber);
        int number = Integer.parseInt(bonusNumber);
        validateBonusNumberDuplicated(winningNumbers, number);
        validateBonusNumberOutOfBound(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumberIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_INPUT_MONEY_IS_NOT_NUMBER
                    .getMessage());
        }
    }

    private void validateBonusNumberDuplicated(WinningNumbers winningNumbers, int bonusNumber) {
        boolean isBonusNumberDuplicated = winningNumbers.getWinningNumbers()
                .contains(bonusNumber);
        if (isBonusNumberDuplicated) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_DUPLICATED_BONUS_NUMBER
                    .getMessage());
        }
    }

    private void validateBonusNumberOutOfBound(int bonusNumber) {
        if (bonusNumber < Bounds.LOWER_BOUND.getValue() || bonusNumber > Bounds.UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_OUT_OF_BOUND
                    .getMessage());
        }
    }
}
