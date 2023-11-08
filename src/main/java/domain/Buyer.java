package domain;

import java.util.List;
import validator.Validator;

public class Buyer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Buyer(List<Integer> winningNumbers, int bonusNumber)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Validator.validateLottoNumbersUniqueness(winningNumbers);
        Validator.validateWinningNumberCount(winningNumbers);
        Validator.validateWinningNumbersInRange(winningNumbers);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateBonusNumberInRange(bonusNumber);
        Validator.validateBonusNumberUniqueness(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
