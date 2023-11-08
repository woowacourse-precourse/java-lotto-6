package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers, NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.NOT_LOTTO_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers, int minNumber, int maxNumber) {
        if (!numbers.stream()
                .allMatch(number -> number >= minNumber && number <= maxNumber)) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        if (numbers.stream()
                .anyMatch(number -> set.contains(number))) {
            throw new IllegalArgumentException(Error.CONTAINS_DUPLICATE.getMessage());
        }
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public int countMatches(Lotto lotto) {
        return (int) getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    public boolean matchWithBonus(int number) {
        return getNumbers().contains(number);
    }
}
