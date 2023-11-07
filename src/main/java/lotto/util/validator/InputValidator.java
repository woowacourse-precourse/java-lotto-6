package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.exception.ErrorMessage;

public class InputValidator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public static void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_INPUT.message());
        }
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            System.out.println(ErrorMessage.BLANK_INPUT.message());
            throw new IllegalArgumentException();
        }
    }
}
