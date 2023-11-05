package lotto.domain;

import lotto.validator.BallValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    private void validate(int number) {
        BallValidator.validate(number);
    }
}
