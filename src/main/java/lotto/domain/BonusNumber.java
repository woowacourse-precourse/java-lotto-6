package lotto.domain;

import lotto.Validator.NumberValidator;
import lotto.util.Parser;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(String input) {
        int bonus = Parser.toInteger(input);
        NumberValidator.isOutRange(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
