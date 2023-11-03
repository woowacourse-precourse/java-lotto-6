package lotto.exception;

import lotto.constant.ExceptionConstant;

public class PurchaseValidationException extends IllegalArgumentException {

    public PurchaseValidationException(String message) {
        super(message);
    }

    public static void checkIsNumeric(String inputAmount) {
        if (!inputAmount.matches(ExceptionConstant.NUMERIC_PATTERN)) {
            throw new PurchaseValidationException(ExceptionConstant.PURCHASE_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void checkValidPurchaseAmount(int amount) {
        if (amount % ExceptionConstant.LOTTO_TICKET_PRICE_UNIT != 0) {
            throw new PurchaseValidationException(ExceptionConstant.PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }
}