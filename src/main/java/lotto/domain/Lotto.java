package lotto.domain;

import static lotto.constant.GameRule.*;
import static lotto.exception.ExceptionMessage.*;

import java.util.List;

import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException(LOTTO_INVALID_SIZE.getMessage());
        }

        if (isDuplicated(numbers)) {
            throw new LottoException(LOTTO_DUPLICATED_ERROR.getMessage());
        }

        if (isNumbersNotInRange(numbers)) {
            throw new LottoException(LOTTO_OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
            .distinct()
            .count() != numbers.size();
    }

    private boolean isNumbersNotInRange(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(this::isNumberNotInRange);
    }

    private boolean isNumberNotInRange(int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }
}
