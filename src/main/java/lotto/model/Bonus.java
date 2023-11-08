package lotto.model;

import lotto.controller.exception.Exception;

import java.util.List;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        Exception.bonus(bonus);
        this.bonus = bonus;
    }
}
