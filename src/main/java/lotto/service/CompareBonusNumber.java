package lotto.service;

import lotto.Lotto;
import lotto.readUserInput.BonusNumbers;

public class CompareBonusNumber {
    private Lotto lotto;

    public CompareBonusNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public String isThereBonus() {
        if (lotto.isContainNumber(BonusNumbers.number)) {
            return "2nd";
        } else if (!lotto.isContainNumber(BonusNumbers.number)) {
            return "3rd";
        }
        return null;
    }


}
