package lotto.util.exception.parental;

import static lotto.util.Constants.ERROR;

import lotto.util.enums.ErrorMessage;

public class AssertionCustomError extends AssertionError{
    protected AssertionCustomError(ErrorMessage errorMessage) {
        super(ERROR + errorMessage.getMessage());
    }
}
