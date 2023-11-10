package lotto.domain;

import lotto.validator.ValidationUtils;

public class BonusNumber {
    private final int number;

    private BonusNumber(String input) {
        this.number = validate(input);
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(input);
    }

    private int validate(String input) {
        int number = ValidationUtils.validateInteger(input);
        ValidationUtils.validateRange(number);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
