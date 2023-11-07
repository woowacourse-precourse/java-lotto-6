package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 | hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        long uniqueCounts = numbers.stream()
                .distinct()
                .count();

        return numbers.size() != uniqueCounts;
    }
}
