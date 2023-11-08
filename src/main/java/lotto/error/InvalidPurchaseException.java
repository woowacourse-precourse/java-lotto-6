package lotto.error;

import lotto.view.ErrorMessage;

public class InvalidPurchaseException extends IllegalArgumentException {
    public InvalidPurchaseException(ErrorMessage message) {
        super(message.getMessage());
    }
}