package domain;

import java.util.List;
import validator.Validator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Validator.validateWinningNumbersUniqueness(winningNumbers);
        Validator.validateWinningNumberCount(winningNumbers);
        Validator.validateWinningNumbersInRange(winningNumbers);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateBonusNumberInRange(bonusNumber);
        Validator.validateBonusNumberUniqueness(winningNumbers, bonusNumber);
    }
}
