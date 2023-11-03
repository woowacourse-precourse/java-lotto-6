package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개의 숫자로만 구성되어 있어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복되지 않은 숫자로 구성되어 있어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deduplicateNumbers = new HashSet<>(numbers);
        if (deduplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
