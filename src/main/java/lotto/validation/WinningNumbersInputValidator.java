package lotto.validation;

import lotto.utils.Constants;

public class WinningNumbersInputValidator {
    public static void validate(String input) {
        validateNotEmpty(input);
        validateContainsComma(input);
    }

    private static void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(Constants.EMPTY_INPUT_MSG);
        }
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(Constants.MISSING_COMMA_MSG);
        }
    }
}
