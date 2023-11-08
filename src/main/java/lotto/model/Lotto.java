package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ExceptionMessage;
import lotto.utils.GameNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != GameNumber.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_SIZE.getMessage());
        }
        for (Integer number : numbers) {
            validateRange(number);
        }
        validateDuplication(numbers);
    }

    public void validateRange(Integer number) {
        if (number > GameNumber.MAX_RANGE.getNumber() || number < GameNumber.MIN_RANGE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> validateNumbers = new HashSet<>(numbers);
        if (validateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
