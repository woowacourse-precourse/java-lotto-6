package lotto.exception;

import lotto.constant.ErrorMessage;

public class InvalidPurchaseAmountException extends IllegalArgumentException {

    public InvalidPurchaseAmountException(ErrorMessage message) {
        super(message.getMessage());
    }
}
