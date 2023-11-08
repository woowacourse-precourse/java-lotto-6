package domain;

import java.util.List;
import validator.InputValidator;

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
        InputValidator.validateLottoNumbersUniqueness(winningNumbers);
        InputValidator.validateWinningNumberCount(winningNumbers);
        InputValidator.validateWinningNumbersInRange(winningNumbers);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        InputValidator.validateBonusNumberInRange(bonusNumber);
        InputValidator.validateBonusNumberUniqueness(winningNumbers, bonusNumber);
    }
}
