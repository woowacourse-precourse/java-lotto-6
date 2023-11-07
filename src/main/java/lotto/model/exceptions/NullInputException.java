package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.NULL_INPUT_MESSAGE;

public class NullInputException extends IllegalArgumentException {
    public NullInputException() {
        super(NULL_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
