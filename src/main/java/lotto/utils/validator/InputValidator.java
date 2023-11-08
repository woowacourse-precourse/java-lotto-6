package lotto.utils.validator;

import static lotto.constant.ExceptionMessage.NO_EMPTY_ERROR_MESSAGE;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(NO_EMPTY_ERROR_MESSAGE);
        }
    }
}
