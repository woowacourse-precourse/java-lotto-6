package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;

public class DuplicatedNumberException extends IllegalArgumentException {
    public DuplicatedNumberException() {
        super(DUPLICATED_NUMBER_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
