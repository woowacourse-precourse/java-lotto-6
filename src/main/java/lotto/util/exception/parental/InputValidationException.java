package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public abstract class InputValidationException extends IllegalArgumentException{

    protected InputValidationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
    }
}
