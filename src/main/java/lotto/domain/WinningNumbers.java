package lotto.domain;

import java.util.List;
import lotto.validator.WinningNumbersValidator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        WinningNumbersValidator.validateLength(winningNumbers);
        WinningNumbersValidator.validateMinNumber(winningNumbers);
        WinningNumbersValidator.validateMaxNumber(winningNumbers);
        WinningNumbersValidator.validateDuplicateNumber(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
