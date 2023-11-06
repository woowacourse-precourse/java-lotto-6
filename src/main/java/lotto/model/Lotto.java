package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int NUMBERS_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicateNumbers(numbers);
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
}
