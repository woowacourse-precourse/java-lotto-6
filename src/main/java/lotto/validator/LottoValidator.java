package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final int MAX_LOTTO_SIZE = 6;
    private static final String SIZE_EXCEPTION = "[ERROR] ";
    private static final String DUPLICATE_EXCEPTION = "[ERROR] ";
    private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] ";

    public static void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRangeOfNumber(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private static void validateRangeOfNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }
}
