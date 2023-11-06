package lotto.domain;

import static lotto.validator.Validator.validateBonusNumber;
import static lotto.validator.Validator.validateWinningNumbers;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return this.winningNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }

}
