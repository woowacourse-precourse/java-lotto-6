package lotto.validator;

import static lotto.constants.LottoConstants.ZERO;
import static lotto.constants.ValidationConstants.ERROR_NEGATIVE_NUMBER;
import static lotto.constants.ValidationConstants.ERROR_NOT_A_NUMBER;

import java.util.List;

public class InputNumbersValidator {
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
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validatePositiveInteger(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }
}
