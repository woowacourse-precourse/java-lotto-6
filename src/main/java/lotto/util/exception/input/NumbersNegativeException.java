package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumbersNegativeException extends InputValidationException {
    public NumbersNegativeException() {
        super(ErrorMessage.NUMBER_CANNOT_BE_NEGATIVE);
    }
}
