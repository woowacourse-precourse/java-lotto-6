package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumbersNullException extends InputValidationException {
    public NumbersNullException() {
        super(ErrorMessage.NUMBER_CANNOT_BE_NULL_EMPTY);
    }
}
