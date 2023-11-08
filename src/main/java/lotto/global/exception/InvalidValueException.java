package lotto.global.exception;

import lotto.global.enums.ErrorMessage;

public class InvalidValueException extends IllegalArgumentException{
    public InvalidValueException(ErrorMessage errorMessage){super(errorMessage.getMessage());}
}
