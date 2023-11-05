package lotto.domain;

import java.util.List;

public class WinningManager {
    List<Integer> winningNumber;
    int bonusNumber;

    public WinningManager(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
