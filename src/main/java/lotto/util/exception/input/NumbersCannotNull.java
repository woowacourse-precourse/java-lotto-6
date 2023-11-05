package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class NumbersCannotNull extends InputValidationException{
    public NumbersCannotNull() {
        super(ErrorMessage.NUMBER_CANNOT_BE_NULL);
    }
}
