package lotto.model.domain;

import java.util.List;

public class Referee {

    public final List<Integer> winningNumbers;
    public final int BonusNumber;

    public Referee(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        BonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return BonusNumber;
    }
}
