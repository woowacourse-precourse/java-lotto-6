package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.ErrorMessage;

public class InputValidator {
    private static final String NUMBERS_REGEX = "^(\\d+(,\\d+)*)+$";
    private static final Pattern NUMBERS_PATTERN = Pattern.compile(NUMBERS_REGEX);
    private static final String NUMBER_REGEX = "\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public static void verifyValidaNumberFormat(String input) {
        if (!NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.get());
        }
    }

    public static void verifyNonEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.get());
        }
    }

    public static void verifyNumericString(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.get());
        }
    }
}
