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
        validateBonusNumberDuplication(winningNumbers, bonusNumber);
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

    private void validateBonusNumberDuplication(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 보너스 번호와 중복되는 번호가 없어야 합니다.");
        }
    }
}
