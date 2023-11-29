package lotto.dto;

import lotto.model.BonusNumber;
import lotto.model.WinnerNumber;

public class WinnerAndBonusNumber {
    private final WinnerNumber winnerNumber;
    private final BonusNumber bonusNumber;

    public WinnerAndBonusNumber(WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinnerNumber getWinnerNumber() {
        return winnerNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
