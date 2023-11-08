package lotto.util.validate;

import java.util.regex.Pattern;
import lotto.util.ErrorMessage;

public class InputValidator {

    private static final String REGEX = "^[0-9]+$";

    public static void validateInput(String input) {
        checkInputEmpty(input);
        checkInputIsNumeric(input);
    }

    private static void checkInputEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private static void checkInputIsNumeric(String input) {
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
