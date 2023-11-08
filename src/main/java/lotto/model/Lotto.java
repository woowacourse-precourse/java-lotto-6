package lotto.model;

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
        if (numbers.size() != Rule.LOTTO_NUMBERS_DIGITS.value()) {
            throw new IllegalArgumentException();
        }
        validateOverlap(numbers);
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> wholeNumbers = new HashSet<>(numbers);

        if (wholeNumbers.size() != Rule.LOTTO_NUMBERS_DIGITS.value()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_OVERLAP.value());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
