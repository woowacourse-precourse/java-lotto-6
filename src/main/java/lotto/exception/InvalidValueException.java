package lotto.exception;

import lotto.enums.ErrorMessage;

public class InvalidValueException extends IllegalArgumentException{
    public InvalidValueException(ErrorMessage errorMessage){super(errorMessage.getMessage());}
}
