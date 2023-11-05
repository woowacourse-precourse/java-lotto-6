package lotto.domain;

import static lotto.constant.ExceptionMessage.NO_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.OUT_OF_RANGE_ERROR_MESSAGE;

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
        if (numbers.size() != 6) {
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
        return new HashSet<>(numbers).size() != 6;
    }

    private boolean isOutOfRange(int number) {
        return 45 < number || number < 1;
    }
}
