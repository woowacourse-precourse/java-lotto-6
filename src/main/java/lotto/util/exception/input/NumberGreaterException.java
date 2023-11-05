package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class InvalidNumberException extends InputValidationException {
    protected InvalidNumberException() {
        super(ErrorMessage.NUMBER_LESS_THAN_45);
    }
}
