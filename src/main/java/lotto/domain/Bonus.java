package lotto.domain;

import lotto.common.validate.Validate;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        try {
            Validate.bonusHitLottoNumberValidate(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
