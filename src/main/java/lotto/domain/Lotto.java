package lotto.domain;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.exception.ExceptionMessage.LOTTO_SIZE_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_RANGE_EXCEPTION;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(this::validateRange);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int noDuplicate = numbers.stream().distinct().toList().size();

        if (noDuplicate != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public int calculateMatchCount(List<Integer> matchNumbers) {
        return (int) matchNumbers.stream().filter(numbers::contains).count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
