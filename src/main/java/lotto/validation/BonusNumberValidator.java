package lotto.validation;

import lotto.domain.WinningNumber;
import lotto.enums.ErrorMessage;

public class BonusNumberValidator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private BonusNumberValidator() {
    }

    public static void validateRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNotContainedInWinningNumber(int number, WinningNumber winningNumber) {
        if (winningNumber.isContains(number)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_IN_WINNING_NUMBER.getMessage());
        }
    }
}
