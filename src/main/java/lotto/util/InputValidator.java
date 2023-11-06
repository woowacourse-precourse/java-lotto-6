package lotto.util;

import static lotto.util.ExceptionMessage.INVALID_INPUT_NUMERIC;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public static int validNumber(String input) {
        return parseInt(input);
    }

    private static int parseInt(String userInput) {
        if (validateNumeric(userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMERIC.getMessage());
        }
        return Integer.parseInt(userInput);
    }

    private static boolean validateNumeric(String userInput) {
        return !NUMBER_REGEX.matcher(userInput).matches();
    }
}
