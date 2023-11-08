package lotto.validator;

import lotto.constants.ValidationConstants;

public class InputNumberValidator {
    private static final int MIN_POSITIVE_NUMBER = 0;

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
            throw new IllegalArgumentException(ValidationConstants.ERROR_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validatePositiveInteger(int number) {
        if (number < MIN_POSITIVE_NUMBER) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }
}
