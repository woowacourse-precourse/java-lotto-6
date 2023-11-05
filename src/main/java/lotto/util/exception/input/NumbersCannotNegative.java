package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumbersCannotZero extends InputValidationException {
    public NumbersCannotZero() {
        super(ErrorMessage.NUMBER_CANNOT_BE_ZERO);
    }
}
