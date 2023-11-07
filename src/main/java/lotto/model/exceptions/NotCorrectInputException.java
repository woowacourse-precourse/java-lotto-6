package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.NOT_CORRECT_INPUT_MESSAGE;

public class NotCorrectInputException extends IllegalArgumentException {
    public NotCorrectInputException() {
        super(NOT_CORRECT_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
