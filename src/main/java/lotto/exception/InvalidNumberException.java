package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.INPUT_NON_NUMBER;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super(INPUT_NON_NUMBER);
    }
}
