package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ExceptionModule;

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
        validateDub(numbers);
        validateBoundary(numbers);
    }

    private void validateDub(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBoundary(List<Integer> numbers) {
        for (Integer num : numbers) {
            ExceptionModule.checkNumBoundary(num);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
