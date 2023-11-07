package lotto.model;

import static lotto.util.message.ErrorMessages.LOTTO_DUPLICATION_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_LENGTH_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_RANGE_EXCEPTION;

import java.util.List;

public class Lotto {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_EXCEPTION);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
    }

    private boolean isValidRange(Integer number) {
        return LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != findDistinctCount(numbers);
    }

    private long findDistinctCount(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
