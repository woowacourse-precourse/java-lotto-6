package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != Constants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATION.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
            .anyMatch(number -> number < Constants.MIN_RANGE || number > Constants.MAX_RANGE);

        if (isOutOfRange) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
