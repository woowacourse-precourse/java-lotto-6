package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public class InvalidNumberFormatException extends NumberFormatException{
    protected InvalidNumberFormatException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
    }
}
