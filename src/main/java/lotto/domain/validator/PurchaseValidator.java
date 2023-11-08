package lotto.domain.validator;

import lotto.exception.ErrorCode;

public class PurchaseValidator {
    private static final int LOTTO_PRICE = 1000;

    public long validatePurchaseAmount(String inputPurchaseAmount) {
        validateNullorEmpty(inputPurchaseAmount);

        long amount = validateNumberType(inputPurchaseAmount);
        validateAmountPositive(amount);
        validateAmountFormate(amount);
        return amount;
    }

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

    private void validateAmountFormate(long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }
}