package lotto.Model.Domain;

import java.util.List;

public class Raffle {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Raffle(List<Integer> winningNumbers, int bonusNumber) {
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
