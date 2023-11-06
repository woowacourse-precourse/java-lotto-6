package lotto.util.validator;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningNumbersValidator implements InputValidator<List<Integer>> {
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    @Override
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateEachNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SIZE_IS_SMALL);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_IS_DUPLICATED);
        }
    }

    private void validateEachNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(Integer number) {
        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE);
        }
    }
}
