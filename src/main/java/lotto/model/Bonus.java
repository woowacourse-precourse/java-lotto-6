package lotto.model;

import static lotto.InputValidator.bonusValidator;

import java.util.List;

public class Bonus {

    private final int bonus;

    public Bonus(List<Integer> lotto, String bonus) {
        this.bonus = bonusValidator(lotto, bonus);
    }

    public int getBonus() {
        return bonus;
    }

}
