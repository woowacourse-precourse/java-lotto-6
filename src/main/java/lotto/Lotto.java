package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (duplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        return uniqueNumber.size() != numbers.size();
    }
}
