package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int NUMBERS_LENGTH = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicateNumbers(numbers);
        validateRangeOverNumber(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersToSet = new HashSet<>(numbers);
        if (numbersToSet.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeOverNumber(List<Integer> numbers) {
        long overNumberCount = numbers.stream()
                .filter(number -> number > LOTTO_MAX_NUMBER
                        || number < LOTTO_MIN_NUMBER).count();

        if (overNumberCount != 0) {
            throw new IllegalArgumentException();
        }
    }
}
