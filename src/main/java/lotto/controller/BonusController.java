package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class BonusController {
    public Bonus create(int bonus, Lotto lotto) {
        return new Bonus(bonus, lotto);
    }
}

