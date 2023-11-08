package lotto.validator;

import java.util.List;

public class InputCSVNumbersValidator {
    private InputCSVNumbersValidator() {
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
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

    }

    private static void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }
}
