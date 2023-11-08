package lotto.domain.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Validation {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_PER_LOTTO = 6;

    private Validation() {
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBER_PER_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_LOTTO_NUMBERS_COUNT.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_PER_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }

        if (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
