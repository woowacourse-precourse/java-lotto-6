package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
