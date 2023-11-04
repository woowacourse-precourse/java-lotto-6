package lotto.model;

import lotto.Lotto;
import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto winnerLotto, int bonusNumber) {
        BonusNumberValidator.validate(winnerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
