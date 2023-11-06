package lotto.exception;

import lotto.constant.ErrorMessage;

public class InvalidPurchaseAmountException extends IllegalArgumentException {

    public InvalidPurchaseAmountException() {
        super(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }
}
