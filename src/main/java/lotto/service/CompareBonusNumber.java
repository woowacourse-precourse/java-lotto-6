package lotto.service;

import lotto.Lotto;
import lotto.readUserInput.BonusNumbers;

public class CompareBonusNumber {
    private Lotto lotto;

    public CompareBonusNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public Reward isThereBonus() {
        if (lotto.isContainNumber(BonusNumbers.number)) {
            return Reward.SECOND_PLACE;
        } else if (!lotto.isContainNumber(BonusNumbers.number)) {
            return Reward.THIRD_PLACE;
        }
        return null;
    }


}
