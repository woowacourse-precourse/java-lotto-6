package lotto.validator;

import lotto.domain.PurchaseAmount;
import lotto.exception.ErrorMessage;

public class PurchaseAmountValidator {
    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MESSAGE.getMessage());
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_CHARACTER_MESSAGE.getMessage());
        }
    }

    public static void validatePurchaseAmount(final int amount) {
        validatePurchaseAmountIsZero(amount);
        validatePurchaseAmountUnit(amount);
    }

    private static void validatePurchaseAmountIsZero(final int amount) {
        if (0 == amount) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_IS_ZERO_MESSAGE.getMessage());
        }
    }

    private static void validatePurchaseAmountUnit(final int amount) {
        if (amount % PurchaseAmount.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE.getMessage());
        }
    }
}
