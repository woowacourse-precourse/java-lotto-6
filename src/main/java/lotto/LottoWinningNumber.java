package lotto;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumber, int bonusNumber) {
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
