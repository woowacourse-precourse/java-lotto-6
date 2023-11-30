package lotto.exception;

import static lotto.message.ErrorMessage.INVALID_COUNT_FORMAT;
import static lotto.message.ErrorMessage.INVALID_PARSE_INT;

public class ParseIntException extends UserInputException {

    public ParseIntException() {
        super(INVALID_PARSE_INT.getMessage());
    }

    public ParseIntException(Throwable cause) {
        super(INVALID_COUNT_FORMAT.getMessage(),cause);
    }
}
