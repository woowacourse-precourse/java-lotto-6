package lotto.domain;

import lotto.constant.JudgeBonus;

public class PrizeTotalNUmber {
    private final WinnerNumbers winnerNumbers;
    private final BonusNumber bonusNumber;

    public PrizeTotalNUmber(WinnerNumbers winnerNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }
}
