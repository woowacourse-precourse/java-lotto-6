package lotto.error.exception;

import lotto.error.ErrorCode;

public class InputException extends IllegalArgumentException {

    public InputException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}