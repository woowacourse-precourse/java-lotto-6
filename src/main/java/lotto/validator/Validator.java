package lotto.validator;

import lotto.manager.Exception;

public class Validator {
    private static final int DEFAULT_PURCHASE_AMOUNT = 1000;

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < DEFAULT_PURCHASE_AMOUNT) {
            Exception.PURCHASE_AMOUNT_OUT_OF_RANGE.throwing();
        }

        if (purchaseAmount % DEFAULT_PURCHASE_AMOUNT != 0) {
            Exception.PURCHASE_AMOUNT_WRONG_UNIT.throwing();
        }
    }
}
