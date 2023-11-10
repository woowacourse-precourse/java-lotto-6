package lotto.domain;

import lotto.validator.ValidationUtils;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = validate(number);
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    private int validate(int number) {
        ValidationUtils.validateRange(number);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
