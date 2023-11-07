package lotto.domain;

import java.util.List;

public class WinningNumbers {

    public static final int WINNING_NUM_SIZE = 6;

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != WINNING_NUM_SIZE;
    }

}
