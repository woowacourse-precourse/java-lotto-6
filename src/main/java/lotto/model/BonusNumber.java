package lotto.model;


import java.util.List;

import static lotto.utils.ErrorMessage.BONUS_NUMBER_NOT_UNIQUE_NUMBER_FROM_WINNING_NUMBERS;
import static lotto.utils.ErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE_NUMBER;

public class BonusNumber {
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    private final Integer bonusNumber;

    public BonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        validateElementInRange(bonusNumber);
        validateUniqueness(winningNumbers, bonusNumber);
    }

    private void validateElementInRange(Integer number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE_NUMBER.getDescription());
        }
    }

    private void validateUniqueness(List<Integer> target, Integer number) {
        if (target.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_UNIQUE_NUMBER_FROM_WINNING_NUMBERS.getDescription());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}