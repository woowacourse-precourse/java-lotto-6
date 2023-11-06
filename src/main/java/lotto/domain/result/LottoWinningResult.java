package lotto.domain.result;

import java.util.List;

public class LottoWinningResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningResult(List<Integer> winningNumbers, int bonusNumber) {
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
