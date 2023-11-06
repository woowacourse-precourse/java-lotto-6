package lotto;

import static lotto.Exception.INVALID_WINNING_NUMBER_RANGE;
import static lotto.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;

import java.util.List;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        numbers.forEach(this::validateNumberRange);

        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }
}
