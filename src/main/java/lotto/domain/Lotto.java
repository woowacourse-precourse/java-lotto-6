package lotto.domain;

import static common.ErrorCode.LOTTO_NUMBERS_INVALID_RANGE;
import static common.ErrorCode.LOTTO_NUMBERS_INVALID_SIZE;

import common.exception.InvalidArgumentException;
import java.util.List;

public class Lotto {

    public static final int NUMBERS_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_INVALID_SIZE);
        }

        if (!isValidRageNumbers(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_INVALID_RANGE);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == NUMBERS_SIZE;
    }

    private boolean isValidRageNumbers(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isRangeNumber);
    }

    private boolean isRangeNumber(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
