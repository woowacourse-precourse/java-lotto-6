package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
