package lotto.exception;

import lotto.exception.errorcode.InputErrorCode;

public class InputException extends IllegalArgumentException {
    private final InputErrorCode errorCode;

    public InputException(final InputErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
