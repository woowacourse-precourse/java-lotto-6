package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class NumbersCannotEmpty extends InputValidationException{
    public NumbersCannotEmpty() {
        super(ErrorMessage.NUMBER_CANNOT_BE_EMPTY);
    }
}
