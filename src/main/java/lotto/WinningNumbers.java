package lotto;

import static lotto.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;

import java.util.List;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
        }
    }
}
