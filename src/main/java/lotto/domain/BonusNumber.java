package lotto.domain;

import lotto.Validator.LottoValidator;
import lotto.util.Parser;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(String input) {
        int bonus = Parser.toInteger(input);
        LottoValidator.isInRange(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
