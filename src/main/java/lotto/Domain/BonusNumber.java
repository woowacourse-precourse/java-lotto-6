package lotto.Domain;

import lotto.Domain.Validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNum;

    public BonusNumber(int bonusNum) {
        validate(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validate(int number) {
        BonusNumberValidator.doValidate(number);
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
