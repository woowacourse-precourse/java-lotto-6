package lotto.domain;

import static lotto.message.ErrorMessage.DUPLICATE_NUMBERS_ERROR;
import static lotto.message.ErrorMessage.INVALID_COUNT_OF_WINNING_NUMBERS_ERROR;
import static lotto.message.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        isNumberDuplicate(numbers);
    }

    private void isNumberRangeValid(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
            }
        }
    }

    private void isNumberDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
