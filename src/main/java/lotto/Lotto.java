package lotto;

import static lotto.util.ErrorConstants.DUPLICATE_NUMBER;
import static lotto.util.ErrorConstants.OVER_RANGE;
import static lotto.util.ErrorConstants.OVER_SIZE;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OVER_SIZE);
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(OVER_RANGE);
            }
        }
    }

}
