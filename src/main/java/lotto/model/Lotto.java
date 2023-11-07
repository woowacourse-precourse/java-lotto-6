package lotto.model;

import static lotto.util.message.ErrorMessages.LOTTO_DUPLICATION_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_LENGTH_EXCEPTION;
import static lotto.util.message.ErrorMessages.LOTTO_RANGE_EXCEPTION;

import java.util.List;
import lotto.util.validator.NumberRangeValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
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
        if (NumberRangeValidator.isInvalidRange(number)) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
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
