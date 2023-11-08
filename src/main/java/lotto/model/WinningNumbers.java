package lotto.model;

import java.util.List;

import static lotto.utils.ErrorMessage.*;

public class WinningNumbers {
    private static final Integer VALID_LENGTH = 6;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> numbers) {
        hasValidLength(numbers);
        hasUniqueElement(numbers);
        hasWithinRangeElement(numbers);
    }

    private void hasValidLength(List<Integer> numbers) {
        if (numbers.size() != VALID_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE_IN_LENGTH.getDescription());
        }
    }

    private void hasUniqueElement(List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream().distinct().count();
        if (uniqueNumberCount != VALID_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_UNIQUE_NUMBER.getDescription());
        }
    }

    private void hasWithinRangeElement(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE_NUMBER.getDescription());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}