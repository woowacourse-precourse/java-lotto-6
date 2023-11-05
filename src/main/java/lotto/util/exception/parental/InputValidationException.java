package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public abstract class InputValidationException extends IllegalArgumentException{
    private final static String ERROR = "[ERROR] ";

    private final ErrorMessage errorMessage;

    protected InputValidationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage(){
        return errorMessage;
    }
}
