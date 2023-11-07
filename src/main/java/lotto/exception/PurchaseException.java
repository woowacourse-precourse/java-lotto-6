package lotto.exception;

public class PurchaseException extends IllegalArgumentException {

    public PurchaseException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
