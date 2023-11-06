package lotto.domain.db;

import lotto.constant.Phrases;

public class BonusNumber {
    private int bonus;

    public BonusNumber(String bonus) {
        validateIsNotNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateIsNotNumber(String bonus) {
        if (!bonus.matches("[0-9]+")) {
            throw new IllegalArgumentException(Phrases.notNumberExceptionPhrase);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
