package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class Lotto extends LottoRule {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidLength(numbers)) {
            ExceptionMessage.LOTTO_INVALID_LENGTH.throwException();
        }
        if (isDuplicate(numbers)) {
            ExceptionMessage.LOTTO_DUPLICATE.throwException();
        }
        if (isOutOfRange(numbers)) {
            ExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
        }
    }

}
