package lotto.model;

import java.util.List;

public class LottoDrawMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoDrawMachine(List<Integer> winningNumbers, int bonusNumber) {
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
