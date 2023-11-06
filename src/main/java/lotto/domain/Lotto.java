package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_COUNT_OF_WINNING_NUMBERS_ERROR;
import static lotto.exception.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR;

import java.util.List;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_OF_WINNING_NUMBERS_ERROR);
        }
        isNumberRangeValid(numbers);
    }

    private void isNumberRangeValid(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
            }
        }
    }
    

}
