package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public abstract class MathOperationException extends ArithmeticException{

    protected MathOperationException(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
    }
}
