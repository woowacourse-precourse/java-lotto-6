package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    public int getBonusNumber() {
        int bonusNumber = this.bonusNumber;
        return bonusNumber;
    }
}
