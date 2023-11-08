package lotto.domain;

import lotto.domain.validator.BonusValidator;

import java.util.List;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number, Lotto lotto){
        new BonusValidator(number, lotto);
        this.number = number;
    }

    public Bonus(Integer number){
        new BonusValidator(number);
        this.number = number;
    }
}
