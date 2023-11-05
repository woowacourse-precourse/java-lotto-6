package lotto.validator;

import lotto.Amount;
import lotto.manager.Exception;

public class Validator {
    private static final Amount DEFAULT_PURCHASE_AMOUNT = new Amount("1000");

    public static void validatePurchaseAmount(Amount purchaseAmount) {
        if (purchaseAmount.lessThan(DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_OUT_OF_RANGE.throwing();
        }

        if (!purchaseAmount.isMultipleOf(DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_WRONG_UNIT.throwing();
        }
    }
}
