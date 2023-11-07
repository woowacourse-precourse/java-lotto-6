package lotto.domain;

import lotto.Validator.LottoValidator;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(int bonus) {
        LottoValidator.isInRange(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
