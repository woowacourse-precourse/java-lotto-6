package lotto.validation;

import lotto.exception.EmptyInputException;
import lotto.exception.NegativeOrZeroInputException;
import lotto.exception.NonNumericInputException;

public class InputValidator {

    private static final Integer ZERO = 0;

    private InputValidator() {
    }

    public static void validateBuyAmount(final String buyAmount) {
        if (buyAmount.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(buyAmount)) {
            throw new NonNumericInputException();
        }
        if (!isPositive(buyAmount)) {
            throw new NegativeOrZeroInputException();
        }
    }

    public static void validateWinningNumbers(final String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    public static void validateBonusNumber(final String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(bonusNumber)) {
            throw new NonNumericInputException();
        }
    }

    private static boolean isNumeric(final String number) {
        try {
            Integer.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(final String amount) {
        try {
            Integer numericAmount = Integer.valueOf(amount);
            return (numericAmount > ZERO);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
