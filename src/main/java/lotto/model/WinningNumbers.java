package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE_ERROR.getErrorMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumber = new HashSet<>(numbers);
        if (distinctNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        long count = countInRangeNumber(numbers);
        if (count != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    private long countInRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(WinningNumbers::isInRange)
                .count();
    }

    private static boolean isInRange(int number) {
        return number >= 1 && number <= 45;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
