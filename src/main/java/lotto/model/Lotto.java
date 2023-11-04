package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
