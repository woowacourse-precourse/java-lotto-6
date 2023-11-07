package lotto.Validator;

import lotto.constant.ExceptionMessage;

public class NumberValidator {
    private static final String POSITIVE_INTEGER = "\\d+";

    public static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_BLANK.getMessage());
        }
    }

    public static void isPositiveInteger(String input) {
        if (!input.matches(POSITIVE_INTEGER)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_POSITIVE_INTEGER.getMessage());
        }
    }
}
