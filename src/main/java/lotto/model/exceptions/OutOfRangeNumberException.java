package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.OUT_OF_RANGE_NUMBER_MESSAGE;

public class OutOfRangeNumberException extends IllegalArgumentException {
    public OutOfRangeNumberException() {
        super(OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
