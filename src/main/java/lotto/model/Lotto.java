package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream().distinct().count() < numbers.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException();
        }
    }
}
