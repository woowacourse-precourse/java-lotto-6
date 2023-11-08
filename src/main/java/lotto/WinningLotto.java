package lotto;

import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoBonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoBonusNumber(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }
}
