package lotto.utils;

import static lotto.enums.ExceptionMessageType.INVALID_SEPARATOR_OR_NUMBER_COUNT;
import static lotto.enums.ExceptionMessageType.NUMBER_OUT_OF_RANGE;

import java.util.regex.Pattern;

public class WinningNumbersValidator extends GeneralValidator {
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;

    public static void validateSeparator(String winningNumbers) {
        String REGEX = "^\\d,\\d,\\d,\\d,\\d,\\d$";
        if (!Pattern.matches(REGEX, winningNumbers)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_OR_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateRange(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

}
