package lotto.model;

import lotto.constants.ExceptionMessage;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.LottoSetting.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (hasInvalidSize(numbers) || hasInvalidRange(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_ERROR.message());
        }
    }

    private boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE.value();
    }

    private boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER.value() || number > MAX_LOTTO_NUMBER.value();
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }
}
