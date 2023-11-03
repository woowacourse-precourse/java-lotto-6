package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumbersException;
import lotto.exception.InvalidRangeException;
import lotto.exception.InvalidSizeException;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeException();
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (!isAllValidRange(numbers)) {
            throw new InvalidRangeException();
        }
    }

    private boolean isAllValidRange(final List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isValidRange);
    }

    private boolean isValidRange(final Integer number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    private void validateDuplicates(final List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new DuplicateNumbersException();
        }
    }

    private static boolean hasDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
