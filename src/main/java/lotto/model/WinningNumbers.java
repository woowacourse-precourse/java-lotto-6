package lotto.model;

import java.util.Set;

public class WinningNumbers {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(int[] winningNumbers, int bonusNumber) {
        winningNumber = new WinningNumber(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber, winningNumber.getNumbers());
    }

    public Set<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
