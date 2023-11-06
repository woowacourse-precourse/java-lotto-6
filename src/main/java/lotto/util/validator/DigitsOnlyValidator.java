package lotto.util.validator;

import static lotto.util.message.ErrorMessages.NUMBER_FORMAT_EXCEPTION;

import java.util.regex.Pattern;

public final class DigitsOnlyValidator {
    private static final Pattern DIGITS_PATTERN = Pattern.compile("[0-9]+");

    private DigitsOnlyValidator() {
    }

    public static void validate(String value) {
        if (!matchesPattern(value)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static boolean matchesPattern(String value) {
        return DIGITS_PATTERN.matcher(value).matches();
    }
}
