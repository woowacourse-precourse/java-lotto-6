package lotto.domain;

import java.util.List;

import static lotto.domain.constants.DomainConstants.*;
import static lotto.domain.constants.ErrorMessageConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(SIX_NUMBERS_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(UNIQUE_SIX_NUMBERS_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(NUMBER_RANGE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}