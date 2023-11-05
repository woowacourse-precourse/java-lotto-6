package lotto.exception;

import static lotto.message.ErrorMessage.INVALID_COUNT_FORMAT;

import lotto.message.ErrorMessage;

public class ParseIntException extends IllegalArgumentException {

    public ParseIntException() {
    }

    public ParseIntException(Throwable cause) {
        super(INVALID_COUNT_FORMAT.getMessage(),cause);
    }
}
