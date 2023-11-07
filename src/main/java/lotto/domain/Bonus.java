package lotto.domain;

import lotto.validation.BonusNumberValidator;

public class Bonus {
    private final int number;

    public Bonus(Integer number, Lotto winningLotto) {
        BonusNumberValidator.validateBonusNumber(number, winningLotto);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
