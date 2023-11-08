package lotto.model;

import lotto.controller.exception.Exception;

import java.util.List;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
