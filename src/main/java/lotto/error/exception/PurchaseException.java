package lotto.error.exception;

import lotto.error.ErrorCode;

public class PurchaseException extends IllegalArgumentException {

    public PurchaseException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
