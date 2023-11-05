package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumbersCannotEmpty extends InputValidationException {
    public NumbersCannotEmpty() {
        super(ErrorMessage.NUMBER_CANNOT_BE_EMPTY);
    }
}
