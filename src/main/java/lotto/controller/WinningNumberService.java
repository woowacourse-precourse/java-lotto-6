package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class WinningNumberService {
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public Lotto inputWinningNumbers() {
        this.winningNumbers = UserInput.inputWinningLotto();
        return this.winningNumbers;
    }

    public BonusNumber inputBonusNumber(Lotto winningNumbers) {
        this.bonusNumber = UserInput.inputBonusNumber(winningNumbers);
        return this.bonusNumber;
    }
}
