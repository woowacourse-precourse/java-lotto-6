package lotto.validator;

import lotto.constants.ValidationConstants;

public class LottoPurchaseValidator {
    private static final int PURCHASE_UNIT = 1000; // Assuming that the purchase must be in units of 1000

    private LottoPurchaseValidator() {
    }

    public static void validatePurchase(final int amount) {
        validateAmountForThousand(amount);
    }

    private static void validateAmountForThousand(int amount) {
        if (amount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
