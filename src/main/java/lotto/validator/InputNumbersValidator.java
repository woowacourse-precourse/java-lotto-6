package lotto.validator;

import java.util.List;
import lotto.constants.ValidationConstants;

public class InputNumbersValidator {
    private static final int MIN_NUMBER = 0;

    private InputNumbersValidator() {
    }

    public static void validate(final List<String> inputs) {
        for (String input : inputs) {
            int number = validateNumber(input);
            validatePositiveInteger(number);
        }
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validatePositiveInteger(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }
}
