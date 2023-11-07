package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final int MAX_COUNT = 6;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != this.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getValue());
        }

        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_DUPLICATE.getValue());
        }

        for (Integer i : numbers) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_OUT_OF_RANGE.getValue());
            }
        }
    }

}
