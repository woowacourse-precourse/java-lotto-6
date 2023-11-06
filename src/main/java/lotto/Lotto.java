package lotto;

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
        Set<Integer> deduplicationNumbers = new HashSet<>(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (deduplicationNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().allMatch(v -> v >= 1 && v <= 45) != true) {
            throw new IllegalArgumentException();
        }
    }

}
