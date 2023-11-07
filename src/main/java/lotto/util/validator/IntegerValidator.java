package lotto.util.validator;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;
import static lotto.common.ExceptionMessage.INVALID_INTEGER_ERROR;
import static lotto.common.ExceptionMessage.INVALID_RANGE_ERROR;
import static lotto.common.ExceptionMessage.NUMBER_NOT_IN_RANGE_ERROR;

import java.util.regex.Pattern;

public class IntegerValidator {
    private static final Pattern VALID_INTEGER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    public static void validateInteger(String input) {
        if (!isValidInteger(input)) {
            throw new IllegalArgumentException(INVALID_INTEGER_ERROR);
        }
    }

    private static boolean isValidInteger(String input) {
        return VALID_INTEGER_PATTERN.matcher(input).matches();
    }

    public static void validateRange(String input, int min, int max) {
        validateInteger(input);

        if (min > max) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }

        if (!isBetween(Integer.parseInt(input), min, max)) {
            throw new IllegalArgumentException(String.format(NUMBER_NOT_IN_RANGE_ERROR, MIN_RANGE, MAX_RANGE));
        }
    }

    private static boolean isBetween(int input, int min, int max) {
        return (min <= input) && (input <= max);
    }
}
