package lotto.util;

import java.util.regex.Pattern;

public class ValidationManager {

    private static final String REGEX = "^[0-9]+$";

    public static void validateInput(String input) {
        validateInputEmpty(input);
        validateInputIsNumeric(input);
    }

    private static void validateInputEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private static void validateInputIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isNumeric(String input) {
        return Pattern.matches(REGEX, input);
    }
}
