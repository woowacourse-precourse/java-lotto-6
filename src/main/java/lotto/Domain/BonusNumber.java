package lotto.Domain;

import lotto.Domain.Validator.BonusNumberValidator;

public class BonusNumber {
    private final int bounusNum;

    public BonusNumber(int bounusNum) {
        validate(bounusNum);
        this.bounusNum = bounusNum;
    }

    private void validate(int number) {
        BonusNumberValidator.doValidate(number);
    }

    public int getBounusNum() {
        return bounusNum;
    }
}
