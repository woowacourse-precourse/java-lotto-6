package lotto.exception;

import static lotto.constants.ErrorConstants.ERROR_PREFIX;

import lotto.constants.ErrorConstants;

public class InputException extends IllegalArgumentException {
    private InputException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static InputException of(ErrorConstants errorConstant) {
        return new InputException(errorConstant.getMessage());
    }
}
