package lotto.domain;

import java.util.List;
import java.util.ArrayList;
public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbersWithBonus() {
        List<Integer> winningNumbersWithBonus = new ArrayList<>(winningNumbers);
        winningNumbersWithBonus.add(bonusNumber);

        return winningNumbersWithBonus;
    }
}

