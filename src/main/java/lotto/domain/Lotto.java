package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_RANDOM_BOUND = 1;
    public static final int MAX_RANDOM_BOUND = 45;
    public static final int TOTAL_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoDuplication(numbers);
        validateLottoRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != TOTAL_COUNT) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANDOM_BOUND || number > MAX_RANDOM_BOUND) {
                throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }
}