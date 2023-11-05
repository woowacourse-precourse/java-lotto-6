package lotto.validator;

import lotto.Amount;
import lotto.manager.Exception;

public class Validator {
    public static void validatePurchaseAmount(Amount purchaseAmount) {
        if (purchaseAmount.lessThan(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_OUT_OF_RANGE.throwing();
        }

        if (!purchaseAmount.isMultipleOf(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_WRONG_UNIT.throwing();
        }
    }
}
