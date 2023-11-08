package lotto.domain;

import java.util.List;
import lotto.validation.WinningNumbersValidator;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        WinningNumbersValidator.validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return lotto.countMatches(winningNumbers);
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
