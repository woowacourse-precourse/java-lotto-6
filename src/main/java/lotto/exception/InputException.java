package lotto.exception;

import static lotto.constants.ErrorMessage.ERROR_PREFIX;

import lotto.constants.ErrorMessage;

public class InputException extends IllegalArgumentException {
    private InputException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static InputException of(ErrorMessage errorConstant) {
        return new InputException(errorConstant.getMessage());
    }
}
