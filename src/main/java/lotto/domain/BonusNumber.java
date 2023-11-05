package lotto.domain;

import lotto.constant.ErrorMessages;

import java.util.List;

import static lotto.constant.NumberConstants.*;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(List<Integer> winningNumber, int bonusNumber) {
        hasNoDuplicateNumber(winningNumber, bonusNumber);
        hasCorrectRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void hasNoDuplicateNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void hasCorrectRange(int bonusNumber) {
        if (bonusNumber < NUMBER_RANGE_MIN || bonusNumber > NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
