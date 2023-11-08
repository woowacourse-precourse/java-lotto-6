package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getGeneralNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
