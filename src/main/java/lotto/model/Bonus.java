package lotto.model;

import static lotto.constant.CommonUnits.MAX_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MIN_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessages.WRONG_NUMBER_BOUND;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_NUMBER_BOUND);
        }
    }
}
