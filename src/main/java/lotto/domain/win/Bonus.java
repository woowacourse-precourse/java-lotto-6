package lotto.domain.win;

import lotto.validator.BonusValidator;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        BonusValidator.range(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
