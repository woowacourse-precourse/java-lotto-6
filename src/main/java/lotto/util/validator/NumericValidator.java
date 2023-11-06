package lotto.util.validator;

import static lotto.common.ExceptionMessage.INPUT_INVALID_INTEGER_ERROR;

import java.util.regex.Pattern;

public class NumericValidator {
    private static final Pattern VALID_INTEGER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    public static void validateInteger(String input) {
        if (!isValidInteger(input)) {
            throw new IllegalArgumentException(INPUT_INVALID_INTEGER_ERROR);
        }
    }

    private static boolean isValidInteger(String input) {
        return VALID_INTEGER_PATTERN.matcher(input).matches();
    }
}
