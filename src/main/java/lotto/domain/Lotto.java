package lotto.domain;

import static lotto.util.Constants.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSizeSix(numbers);
        validateDuplication(numbers);
    }

    private static void validateSizeSix(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
