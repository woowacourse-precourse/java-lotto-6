package lotto;

import java.util.List;

public class WinningNumber {
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.winningNumbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().mapToInt(v -> v).min().orElse(0) < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().mapToInt(v -> v).max().orElse(0) > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
