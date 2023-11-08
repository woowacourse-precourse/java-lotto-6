package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkIsDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDuplicate(List<Integer> numbers) {
        Set<Integer> checkIsDuplicateNumbers = new HashSet<>(numbers);
        if (checkIsDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
