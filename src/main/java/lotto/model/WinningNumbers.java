package lotto.model;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isMatching(List<Integer> userNumbers) {
        return winningNumbers.containsAll(userNumbers);
    }

    public boolean isBonusMatching(int userBonusNumber) {
        return userBonusNumber == bonusNumber;
    }
}
