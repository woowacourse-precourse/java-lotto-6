package lotto.validation;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final String ZERO = "0";

    private InputValidator() {
    }

    public static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL.getMessage());
        }
    }

    public static void validateZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }
}
