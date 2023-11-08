package lotto.model;

import lotto.constant.ErrorMessage;
import java.util.List;

public class LotteryNumbers {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public LotteryNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        checkDuplicatedNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkDuplicatedNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_NUMBER);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
