package lotto.validator;

import lotto.domain.PurchaseAmount;

public class PurchaseAmountValidator {
    public static final String PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE =
            "구입 금액은 " + PurchaseAmount.PURCHASE_AMOUNT_UNIT + "단위로 입력해 주세요.";

    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(InputValidator.INVALID_INPUT_CHARACTER);
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
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
        }
    }
}
