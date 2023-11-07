package lotto.domain;

import lotto.constant.ErrorMessages;

import java.util.*;

import static lotto.constant.NumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (isIncorrectNumberSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_COUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isIncorrectNumberSize(List<Integer> numbers) {
        return numbers.size() != WINNING_NUMBER;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (isDuplicatedNumber(uniqueNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isDuplicatedNumber(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != WINNING_NUMBER;
    }

    private void validateNumberRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(num -> num >= NUMBER_RANGE_MIN && num <= NUMBER_RANGE_MAX)
                .count();

        if (isNotEnoughNumber(count)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isNotEnoughNumber(long count) {
        return count != WINNING_NUMBER;
    }

    public int calculateMatchNumber(List<Integer> winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
