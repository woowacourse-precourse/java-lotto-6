package lotto.service;

import lotto.Lotto;
import lotto.readUserInput.BonusNumbers;

public class CompareBonusNumber {
    private Lotto lotto;

    public CompareBonusNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public boolean isThereBonus() {
        return lotto.isContainNumber(BonusNumbers.number);
    }
}
