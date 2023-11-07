package lotto.util.validator;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningNumbersValidator extends AbstractNumberValidator<List<Integer>> {
    private static final int WINNING_NUMBERS_COUNT = 6;

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
}
