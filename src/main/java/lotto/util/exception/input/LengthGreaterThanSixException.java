package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class LengthGreaterThanSixException extends InputValidationException{
    public LengthGreaterThanSixException() {
        super(ErrorMessage.LENGTH_GREATER_THAN_SIX);
    }
}
