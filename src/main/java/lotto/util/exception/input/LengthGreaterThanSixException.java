package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class LengthGreaterThanSixException extends InputValidationException {
    public LengthGreaterThanSixException() {
        super(ErrorMessage.NUMBERS_LENGTH_GREATER_THAN_SIX);
    }
}
