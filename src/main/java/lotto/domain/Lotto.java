package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();

        if (distinctNumber < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (isWrongRangeNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWrongRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER
                        || number > LOTTO_MAX_NUMBER);
    }
}
