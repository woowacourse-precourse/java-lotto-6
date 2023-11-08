package lotto.validation;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;

public class WinningNumbersInputValidator {
    public static void validate(String input) {
        validateNotEmpty(input);
        validateContainsComma(input);
        validateCorrectNumbers(input);
    }

    private static void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(Constants.EMPTY_INPUT_MSG);
        }
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(Constants.MISSING_COMMA_MSG);
        }
    }

    private static void validateCorrectNumbers(String input) {
        String[] numbers = input.split(",");
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicate(numbers);
    }

    private static void validateNumberCount(String[] numbers) {
        if (numbers.length != Constants.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(Constants.INVALID_NUM_COUNT_MSG);
        }
    }

    private static void validateNumberRange(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException(Constants.INVALID_NUM_RANGE_MSG);
            }
            int num = Integer.parseInt(number);
            if (num > Constants.LOTTO_NUM_MAX) {
                throw new IllegalArgumentException(Constants.INVALID_NUM_RANGE_MSG);
            }
        }
    }

    private static void validateNoDuplicate(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(Constants.DUPLICATE_NUM_MSG);
            }
            winningNumbers.add(num);
        }
    }
}
