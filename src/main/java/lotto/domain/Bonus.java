package lotto.domain;

import lotto.domain.validator.BonusValidator;

import java.util.List;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number, List<Integer> lotto){
        new BonusValidator(number, lotto);
        this.number = number;
    }
}
