package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class LottoValidator {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateRange(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoValidationException(LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoValidationException(LottoError.DUPLICATE_WINNING_NUMBER.toString());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new LottoValidationException(LottoError.NUMBER_OUT_OF_RANGE.toString());
        }
    }
}
