package lotto.exception;

import lotto.exception.errorcode.StateErrorCode;

public class StateException extends IllegalStateException {
    private final StateErrorCode errorCode;

    public StateException(final StateErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
