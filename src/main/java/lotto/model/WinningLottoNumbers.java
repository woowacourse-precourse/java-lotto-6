package lotto.model;

import java.util.List;

public class WinningLottoNumbers {
    private final Lotto winningLottoNumbers;
    private final int bonusNumber;

    public WinningLottoNumbers(List<Integer> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = new Lotto(winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean numberContain(int number) {
        return winningLottoNumbers.numberContain(number);
    }
}
