package lotto.utils;

import static lotto.enums.ExceptionMessageType.INVALID_SEPARATOR_OR_NUMBER_COUNT;

import java.util.regex.Pattern;

public class WinningNumbersValidator {
    public static void validateSeparator(String winningNumbers) {
        String REGEX = "^\\d,\\d,\\d,\\d,\\d,\\d$";
        if (!Pattern.matches(REGEX, winningNumbers)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_OR_NUMBER_COUNT.getMessage());
        }
    }
}
