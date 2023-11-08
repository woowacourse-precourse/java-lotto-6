package lotto;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Winning(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersDuplication(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateNumberRange(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbersDuplication(List<Integer> winningNumbers) {
        new Exception().validateDuplicateNumber(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        new Exception().validateNumbersSize(winningNumbers);
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            validateNumberRange(winningNumber);
        }
    }

    private void validateNumberRange(int number) {
        new Exception().validateNumberRange(number);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
