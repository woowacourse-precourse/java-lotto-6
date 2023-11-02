package lotto;

import static lotto.ExceptionCase.NUMBERS_SIZE_MISMATCH;
import static lotto.ExceptionCase.NUMBER_DUPLICATION;
import static lotto.ExceptionCase.NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!correctSize(numbers)) {
            throw new IllegalArgumentException(NUMBERS_SIZE_MISMATCH.message());
        }
        if (!unique(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION.message());
        }
        if (!inRange(numbers)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
    }

    private boolean correctSize(List<Integer> numbers) {
        return numbers.size() == SIZE;
    }

    private boolean unique(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean inRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }
}
