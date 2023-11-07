package lotto.model;

import java.util.List;

public class LottoGame {
    private final int[] winningNumbers;
    private final int bonusNumber;

    public LottoGame(int[] winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
