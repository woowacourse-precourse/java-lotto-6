package lotto.util.validator;

import lotto.util.exception.ErrorCode;

public class PurchaseValidator {
    private void validateNullorEmpty(String inputPurchaseAmount) {
        if (inputPurchaseAmount == null || inputPurchaseAmount.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_PURCHASE_AMOUNT.getMessage());
        }
    }

    private long validateNumberType(String inputPurchaseAmount) {
        try {
            return Long.parseLong(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateAmountPositive(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
