package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class NumberGreaterException extends InputValidationException {
    public NumberGreaterException() {
        super(ErrorMessage.NUMBER_GREATER_THAN_45);
    }
}
