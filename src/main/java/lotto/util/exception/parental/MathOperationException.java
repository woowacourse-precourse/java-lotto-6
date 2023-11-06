package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public abstract class MathOperationException extends ArithmeticException{
    private final ErrorMessage errorMessage;

    protected MathOperationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage(){
        return errorMessage;
    }
}
