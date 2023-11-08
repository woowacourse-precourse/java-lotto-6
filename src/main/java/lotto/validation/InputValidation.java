package lotto.validation;

import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.NULL_EXCEPTION;

import java.util.Arrays;

public class InputValidation {
    private static final String DELIMITER = ",";

    public static int validateDigitAndConvertToDigit(String info) {
        validateBlank(info);
        validateDigit(info);
        return Integer.parseInt(info);
    }

    public static int[] validateDigitsAndConvertToDigits(String info) {
        validateBlank(info);
        String[] splitDigits = info.split(DELIMITER);
        return Arrays.stream(splitDigits).mapToInt(InputValidation::validateDigitAndConvertToDigit).toArray();
    }

    private static void validateBlank(String info) {
        if (isBlank(info)) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private static boolean isBlank(String info) {
        return info == null || info.isBlank();
    }

    private static void validateDigit(String info) {
        try {
            Integer.parseInt(info);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DIGIT_EXCEPTION.getMessage());
        }
    }
}
