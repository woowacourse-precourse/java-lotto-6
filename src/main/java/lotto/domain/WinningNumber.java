package lotto.domain;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for(Integer number: numbers) {
            if(number < MINIMUM_VALUE || number > MAXIMUM_VALUE) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }
}
