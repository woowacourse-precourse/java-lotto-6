package lotto.util.validator;

import lotto.util.exception.ErrorCode;

public class PurchaseValidator {
    private void validateNullorEmpty(String inputPurchaseAmount) {
        if (inputPurchaseAmount == null || inputPurchaseAmount.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_PURCHASE_AMOUNT.getMessage());
        }
    }
}
