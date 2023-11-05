package lotto.util.exception.parental;

import lotto.util.enums.ErrorMessage;

public abstract class MathOperationException extends ArithmeticException{
    private final static String ERROR = "[ERROR] ";

    private final ErrorMessage errorMessage;

    protected MathOperationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage(){
        return errorMessage;
    }
}
