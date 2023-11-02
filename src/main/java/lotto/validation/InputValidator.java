package lotto.validation;

import lotto.enums.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL.getMessage());
        }
    }
}
