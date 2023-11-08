package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public CustomIllegalArgumentException(ErrorCode errorCode) {
        super(errorCode.getFormattedMessage());
    }
}
