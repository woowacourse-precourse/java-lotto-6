package lotto.validator;

import static lotto.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;

import java.util.List;

public class WinningNumbersValidator extends NumberValidator {
    private static final int WINNING_NUMBERS_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        numbers.forEach(NumberValidator::validateRange);
        validateNumberDuplication(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
        }
    }

    private static void validateNumberDuplication(List<Integer> numbers) {
        long numberSize = numbers.stream()
                .distinct()
                .count();

        if (numberSize != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
