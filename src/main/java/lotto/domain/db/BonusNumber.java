package lotto.domain.db;

import lotto.constant.Phrases;
import lotto.exception.bonusNumber.BonusNumberException;

public class BonusNumber {
    private int bonus;

    public BonusNumber(String bonus) {
        validateEmptyInput(bonus);
        validateIsNotNumber(bonus);
        validateOverSRange(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateIsNotNumber(String bonus) {
        new BonusNumberException().isNotNumber(bonus);
    }

    private void validateOverSRange(String bonus) {
        new BonusNumberException().overRange(bonus);
    }

    private void validateEmptyInput(String bonus) {
        new BonusNumberException().emptyInput(bonus);
    }

    public int getBonus() {
        return bonus;
    }
}
