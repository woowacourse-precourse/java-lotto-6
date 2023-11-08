package lotto.util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("\\d+");

    public static void validateInput(String input) {
        validateEmptyInput(input);
        validatePositiveNumber(input);
    }

    public static void validatePositiveNumber(String input) {
        if (!isPositiveNumber(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT_MESSAGE.getErrorMessage());
        }
    }

    private static boolean isPositiveNumber(String input) {
        return POSITIVE_INTEGER_PATTERN.matcher(input).matches();
    }
}
