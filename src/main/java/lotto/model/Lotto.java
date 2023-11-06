package lotto.model;

import java.util.HashSet;
import java.util.List;

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

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
