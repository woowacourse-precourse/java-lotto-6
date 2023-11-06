package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public abstract class InputValidationException extends IllegalArgumentException{
    private final ErrorMessage errorMessage;

    protected InputValidationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage(){
        return errorMessage;
    }
}
