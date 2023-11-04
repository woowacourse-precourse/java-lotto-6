package lotto.validation;

import static constant.ErrorMessage.CHARACTER_INPUT_ERROR_MESSAGE;
import static constant.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static constant.ErrorMessage.NEGATIVE_OR_ZERO_INPUT_ERROR_MESSAGE;

public class InputValidator {

    private InputValidator() {
    }

    public static void validatePurchaseAmount(final String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (!isNumeric(purchaseAmount)) {
            throw new IllegalArgumentException(CHARACTER_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (!isPositive(purchaseAmount)) {
            throw new IllegalArgumentException(NEGATIVE_OR_ZERO_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateWinningNumbers(final String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateBonusNumber(final String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException(CHARACTER_INPUT_ERROR_MESSAGE.getMessage());
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
            return (numericAmount > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
