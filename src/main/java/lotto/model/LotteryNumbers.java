package lotto.model;

import java.util.List;

public class LotteryNumbers {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;
    public LotteryNumbers(List<Integer> winningNumbers, int bonusNumber) {
        checkDuplicatedNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public void checkDuplicatedNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
