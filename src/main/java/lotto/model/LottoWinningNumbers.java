package lotto.model;

import lotto.Lotto;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        // validate winningNumbers
        // validate bonusNumber
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
