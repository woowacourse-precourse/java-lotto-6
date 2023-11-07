package lotto.domain;

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
        validateSizeException(numbers);
        validateDuplicatedExcepiton(numbers);
        validateNumberRangeException(numbers);
    }

    private void validateSizeException(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicatedExcepiton(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRangeException(List<Integer> numbers) throws IllegalArgumentException {
        long result = numbers.stream()
                .filter(num -> num <= 0 || num >= 46)
                .count();
        if (result != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
