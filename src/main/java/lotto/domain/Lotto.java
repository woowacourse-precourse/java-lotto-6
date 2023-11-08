package lotto.domain;

import static common.enumtype.ErrorCode.LOTTO_NUMBERS_DUPLICATED;
import static common.enumtype.ErrorCode.LOTTO_NUMBERS_INVALID_RANGE;
import static common.enumtype.ErrorCode.LOTTO_NUMBERS_INVALID_SIZE;

import common.exception.InvalidArgumentException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int NUMBERS_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_INVALID_SIZE);
        }

        if (!isValidRageNumbers(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_INVALID_RANGE);
        }

        if (!isUniqueNumbers(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_DUPLICATED);
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

    private boolean isUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
