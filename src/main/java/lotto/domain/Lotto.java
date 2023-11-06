package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        uniqueValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR);
        }
    }

    private void uniqueValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Constants.LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_UNIQUE_ERROR);
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < Constants.LOTTO_MIN_NUM || number > Constants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
