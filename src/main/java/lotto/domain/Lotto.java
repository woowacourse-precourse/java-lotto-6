package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        uniqueValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO +
                            ErrorMessage.LOTTO_SIZE_ERROR);
        }
    }

    private void uniqueValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO +
                            ErrorMessage.LOTTO_UNIQUE_ERROR);
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO +
                            ErrorMessage.LOTTO_RANGE_ERROR);
        }
    }
}
