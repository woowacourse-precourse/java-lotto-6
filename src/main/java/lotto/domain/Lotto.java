package lotto.domain;

import static lotto.exception.ExceptionMessage.LOTTO_INVALID_SIZE;
import static lotto.exception.ExceptionMessage.LOTTO_DUPLICATED_ERROR;

import java.util.List;

import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(LOTTO_INVALID_SIZE.getMessage());
        }

        if (isDuplicated(numbers)) {
            throw new LottoException(LOTTO_DUPLICATED_ERROR.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
            .distinct()
            .count() != numbers.size();
    }
}
