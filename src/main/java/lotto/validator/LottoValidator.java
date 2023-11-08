package lotto.validator;

import static lotto.exception.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;

import java.util.List;

public class LottoValidator extends NumberValidator {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        numbers.forEach(NumberValidator::validateRange);
        validateNumberDuplication(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
        }
    }

    private static void validateNumberDuplication(List<Integer> numbers) {
        long numberSize = numbers.stream()
                .distinct()
                .count();

        if (numberSize != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
