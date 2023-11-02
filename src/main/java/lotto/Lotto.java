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
        correctSize(numbers);
        unique(numbers);
        inRange(numbers);
    }

    private void correctSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_MISMATCH.message());
        }
    }

    private void unique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION.message());
        }
    }

    private void inRange(List<Integer> numbers) {
        if (numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
    }
}
