package lotto.model.data;

import java.util.List;
import lotto.model.record.BonusNumber;

public class AnswerNumbers {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public AnswerNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getWinningNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.bonusNumber();
    }
}
