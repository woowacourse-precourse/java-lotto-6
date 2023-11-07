package lotto.domain;

import lotto.constant.ErrorMessages;

import java.util.List;

import static lotto.constant.NumberConstants.*;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(List<Integer> winningNumber, int bonusNumber) {
        hasDuplicateNumber(winningNumber, bonusNumber);
        hasCorrectRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void hasDuplicateNumber(List<Integer> winningNumber, int bonusNumber) {
        if (isContains(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isContains(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }

    private void hasCorrectRange(int bonusNumber) {
        if (isIncorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isIncorrectRange(int bonusNumber) {
        return bonusNumber < NUMBER_RANGE_MIN || bonusNumber > NUMBER_RANGE_MAX;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
