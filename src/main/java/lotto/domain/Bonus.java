package lotto.domain;

import lotto.common.validate.Validate;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        Validate.bonusDomainValidate(number);
    }

    public int getNumber() {
        return number;
    }
}
