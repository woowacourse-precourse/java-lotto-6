package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.BLANK_INPUT_MESSAGE;

public class BlankInputException extends IllegalArgumentException {
    public BlankInputException() {
        super(BLANK_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
