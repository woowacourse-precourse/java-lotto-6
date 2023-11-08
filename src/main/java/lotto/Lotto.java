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

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numSet = new HashSet<Integer>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorType.REPITITION.getErrorMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.NUMBER.getErrorMessage());
        }
        for (int num : numbers) {
            if (num < 1 | num > 45) {
                throw new IllegalArgumentException(ErrorType.RANGE.getErrorMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}