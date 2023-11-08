package lotto.model.validation;

import java.util.List;
import lotto.utils.Constants;
import lotto.view.ExceptionMessage;

public class BonusNumberValidation {
    private final int bonusNumber;

    public BonusNumberValidation(String bonusNumberStr, List<Integer> winningNumbers) {
        int number = validateNumber(bonusNumberStr);
        validateNatural(number);
        validateWithinRange(number);
        validateBonusNumberNotInWinningNumbers(winningNumbers, number);
        this.bonusNumber = number;
    }

    private static int validateNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private void validateNatural(int number) {
        if (number <= Constants.ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private void validateWithinRange(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE_ERROR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
