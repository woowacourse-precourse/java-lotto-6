package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumbersCannotNull extends InputValidationException {
    public NumbersCannotNull() {
        super(ErrorMessage.NUMBER_CANNOT_BE_NULL);
    }
}
