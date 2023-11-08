package lotto.validation;

import java.util.regex.Pattern;
import lotto.utils.NumberConstants;

public class NumberValidator {
    private static final String POSITIVE_DIGIT_REGEX = "^[1-9]+$";

    private NumberValidator() {
    }

    public static void validateNumber(String number) {
        isBlank(number);
        isContainBlank(number);
        isPositiveDigit(number);
    }

    private static void isBlank(String winningNumber) {
        if (winningNumber.isBlank()) {
            throw NumberException.BLANK_EXCEPTION.getException();
        }
    }

    private static void isContainBlank(String winningNumber) {
        if (winningNumber.contains(" ")) {
            throw NumberException.BLANK_CONTAIN_EXCEPTION.getException();
        }
    }

    private static void isPositiveDigit(String number) {
        if (!Pattern.matches(POSITIVE_DIGIT_REGEX, number)) {
            throw NumberException.INVALID_POSITIVE_DIGIT_EXCEPTION.getException();
        }
    }

    public static void validateInRangeNumber(int number) {
        isInRange(number);
    }

    private static void isInRange(int number) {
        if (number < NumberConstants.NUMBER_LEAST_VALUE.getValue()
            || number > NumberConstants.NUMBER_MOST_VALUE.getValue()) {
            throw NumberException.OUT_RANGE_RANGE_EXCEPTION.getException();
        }
    }
}
