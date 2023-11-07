package lotto.exception;

public class InputException extends IllegalArgumentException {

    public InputException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}