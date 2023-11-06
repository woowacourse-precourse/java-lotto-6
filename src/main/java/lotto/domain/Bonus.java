package lotto.domain;

import lotto.common.validate.Validate;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        this.number = validate(number);
    }

    public int getNumber() {
        return number;
    }

    private int validate(int number) {
        try {
            Validate.bonusHitLottoNumberValidate(number);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
