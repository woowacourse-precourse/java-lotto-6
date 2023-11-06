package lotto;

import static lotto.Exception.DUPLICATE_BONUS_NUMBER;
import static lotto.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.Exception.INVALID_WINNING_NUMBER_RANGE;
import static lotto.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;

import java.util.List;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        // numbers
        validateNumberSize(numbers);
        numbers.forEach(this::validateNumberRange);
        validateNumberDuplication(numbers);

        // bonusNumber
        validateNumberRange(bonusNumber);
        validateBonusNumberDuplication(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
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

    private void validateNumberDuplication(List<Integer> numbers) {
        long numberSize = numbers.stream()
                .distinct()
                .count();

        if (numberSize != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberDuplication(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
