package lotto.domain.result;

import java.util.List;

public class WinningResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
