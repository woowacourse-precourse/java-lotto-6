package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class WinningNumberService {
    public Lotto inputWinningNumbers() {
        return UserInput.inputWinningLotto();
    }

    public BonusNumber inputBonusNumber(Lotto winningNumbers) {
        return UserInput.inputBonusNumber(winningNumbers);
    }
}
