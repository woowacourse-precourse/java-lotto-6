package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.NON_DIVISIBLE_MESSAGE;

public class NonDivisibleException extends IllegalArgumentException {
    public NonDivisibleException() {
        super(NON_DIVISIBLE_MESSAGE);
    }
}
