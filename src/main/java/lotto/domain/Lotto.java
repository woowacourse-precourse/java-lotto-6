package lotto.domain;

import java.util.List;
import lotto.constants.Messages;
import lotto.constants.Values;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidLottoNumberCount(numbers)) {
            throw new IllegalArgumentException(Messages.ERROR_COUNT_LOTTO_NUMBER);
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(Messages.ERROR_DUPLICATE_LOTTO_NUMBER);
        }
        if (hasNumberOutsideRange(numbers)) {
            throw new IllegalArgumentException(Messages.ERROR_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isInvalidLottoNumberCount(List<Integer> numbers) {
        return numbers.size() != Values.LOTTO_NUMBER_COUNT;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean hasNumberOutsideRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutsideRange);
    }

    private boolean isOutsideRange(int number) {
        return number < Values.LOTTO_MIN_NUMBER || number > Values.LOTTO_MAX_NUMBER;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
