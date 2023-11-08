package lotto;

import static lotto.constants.Constants.LOTTO_COUNT;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Message.LOTTO_COUNT_ERROR;
import static lotto.constants.Message.LOTTO_DUPLICATED_ERROR;
import static lotto.constants.Message.LOTTO_NUMBER_ERROR;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR.getErrorMessage());
        }
        if (numbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_ERROR.getErrorMessage());
        }
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_ERROR.getErrorMessage());
            }
        }
    }
}
