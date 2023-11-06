package lotto.validation;

import static lotto.messages.ErrorMessages.INVALID_INTEGER_MESSAGE;
import static lotto.messages.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_MESSAGE;
import static lotto.messages.ErrorMessages.INVALID_MULTIPLE_OF_1000_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;

public class IntegerValidator {

    public static void validateInteger(String string) {
        if (!IntegerUtil.isInteger(string)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE.getMessage());
        }
    }

    public static void validateMultipleOf(int value, int multiple) {
        if (value % multiple != 0) {
            ExceptionUtil.throwInvalidValueException(INVALID_MULTIPLE_OF_1000_MESSAGE.getMessage());
        }
    }

    public static void validateInRange(int value, int min, int max) {
        validateSmaller(value, min);
        validateBigger(value, max);
    }

    public static void validateSmaller(int value, int min) {
        if (value < min) {
            ExceptionUtil.throwInvalidValueException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateBigger(int value, int max) {
        if (value > max) {
            ExceptionUtil.throwInvalidValueException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
