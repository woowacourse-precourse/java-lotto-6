package lotto.model;

import lotto.util.ExceptionMessage;
import lotto.util.NumberConst;

public class Bonus {
    private int bonus;

    public Bonus(int bonus, Lotto lotto) {
        validate(bonus, lotto);
        this.bonus = bonus;
    }

    private void validate(int bonus, Lotto lotto) {
        if (!isValidRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage());
        }

        if (isDuplicatedBonus(bonus, lotto)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS.getMessage());
        }
    }

    private boolean isDuplicatedBonus(int bonus, Lotto lotto) {
        return lotto.hasBonus(bonus);
    }

    private boolean isValidRange(int bonus) {
        return bonus >= NumberConst.MIN_RANGE && bonus <= NumberConst.MAX_RANGE;
    }

    public int getBonus() {
        return bonus;
    }
}
