package lotto.validator;

import static lotto.constants.LottoConstants.ZERO;
import static lotto.constants.ValidationConstants.ERROR_NEGATIVE_NUMBER;
import static lotto.constants.ValidationConstants.ERROR_NOT_A_NUMBER;

public class InputNumberValidator {
    private InputNumberValidator() {
    }

    public static void validate(final String input) {
        int number = validateNumber(input);
        validatePositiveInteger(number);
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validatePositiveInteger(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }
}
