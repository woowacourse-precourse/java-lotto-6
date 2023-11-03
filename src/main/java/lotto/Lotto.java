package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        validateExceeded(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (new HashSet(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateExceeded(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
