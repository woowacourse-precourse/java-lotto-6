package lotto.model;

import lotto.util.ExceptionMessage;
import lotto.util.NumberConst;

public class Bonus {
    private int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (!isValidRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage());
        }
    }

    private boolean isValidRange(int bonus) {
        return bonus >= NumberConst.MIN_RANGE && bonus <= NumberConst.MAX_RANGE;
    }

    public int getBonus() {
        return bonus;
    }
}
