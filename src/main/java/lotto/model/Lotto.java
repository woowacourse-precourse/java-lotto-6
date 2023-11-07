package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ErrorCode;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new CustomIllegalArgumentException(ErrorCode.LOTTO_NUMBERS_INVALID_SIZE);
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new CustomIllegalArgumentException(ErrorCode.LOTTO_NUMBERS_DUPLICATED);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new CustomIllegalArgumentException(ErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE);
        }
    }
}
