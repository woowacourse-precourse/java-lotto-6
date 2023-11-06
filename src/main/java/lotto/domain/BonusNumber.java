package lotto.domain;

import java.util.List;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int inputBonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(inputBonusNumber, winningNumbers);
        this.bonusNumber = inputBonusNumber;
    }

    private void validateBonusNumber(int inputBonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(inputBonusNumber);
        validateBonusNumberDuplicationWithWinningNumbers(inputBonusNumber, winningNumbers);
    }

    private void validateBonusNumberRange(int inputBonusNumber) {
        if (!isWithinRange(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_INVALID_ERROR.getMessage());
        }
    }

    private boolean isWithinRange(int inputBonusNumber) {
        return inputBonusNumber >= Constants.LOTTO_MIN_NUMBER && inputBonusNumber <= Constants.LOTTO_MAX_NUMBER;
    }

    private void validateBonusNumberDuplicationWithWinningNumbers(int inputBonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUM_AND_WINNING_NUM_DUPLICATE_ERROR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
