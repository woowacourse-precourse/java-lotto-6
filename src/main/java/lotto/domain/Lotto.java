package lotto.domain;

import static lotto.constant.ExceptionMessage.NO_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.OUT_OF_RANGE_ERROR_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_LENGTH;
    }

    private boolean isOutOfRange(int number) {
        return MAX_NUMBER < number || number < MIN_NUMBER;
    }
}
