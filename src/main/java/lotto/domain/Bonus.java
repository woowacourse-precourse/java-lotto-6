package lotto.domain;

import lotto.common.validate.Validate;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        try {
            Validate.bonusHitLottoNumberValidate(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
