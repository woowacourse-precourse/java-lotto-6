package lotto.exception;

import lotto.common.ErrorMessages;

public class InputValidationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String INPUT_VALUE_LABEL = " 입력 값 : ";

    public InputValidationException(ErrorMessages errorMessage) {
        super(ERROR_MESSAGE.concat(errorMessage.getMessage()));
    }

    public InputValidationException(ErrorMessages errorMessage, String input) {
        super(ERROR_MESSAGE
                .concat(errorMessage.getMessage())
                .concat(INPUT_VALUE_LABEL + input));
    }
}
