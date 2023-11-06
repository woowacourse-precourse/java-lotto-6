package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Numbers must contain exactly 6 integers.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("Numbers must be unique.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("Numbers must be between 1 and 45.");
        }
    }

}
