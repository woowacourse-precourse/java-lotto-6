package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final int MAX_COUNT = 6;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicated(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != this.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OVER_SIZE.getValue());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_DUPLICATED.getValue());
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getValue());
            }
        }
    }

}
