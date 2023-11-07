package lotto.util;

import static lotto.domain.exception.InputException.INVALID_EMPTY_INPUT;
import static lotto.domain.exception.InputException.INVALID_NUMERIC_INPUT;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public static void validNumber(String input) {
        validateNullOrEmpty(input);
        validNumberRange(input);
    }

    private static void validateNullOrEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(INVALID_EMPTY_INPUT.getMessage());
        }
    }

    private static boolean isEmpty(String input) {
        return StringUtils.removeSpace(input).isEmpty();
    }

    private static void validNumberRange(String userInput) {
        if (validateNumeric(userInput)) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    private static boolean validateNumeric(String userInput) {
        return !NUMBER_REGEX.matcher(userInput).matches();
    }
}
