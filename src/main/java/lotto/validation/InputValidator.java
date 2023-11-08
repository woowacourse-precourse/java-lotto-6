package lotto.validation;

import java.util.regex.Pattern;
import lotto.exception.InputException;

public class InputValidator {
    private static final String INTEGER_REGEX = "\\d+";

    public static void validateString(String input) {
        if (isInvalidString(input)) {
            throw new InputException();
        }
    }

    private static boolean isInvalidString(String input) {
        return input == null || input.isBlank();
    }

    public static void validateInteger(String input) {
        if (!Pattern.matches(INTEGER_REGEX, input)) {
            throw new InputException();
        }
    }
}
