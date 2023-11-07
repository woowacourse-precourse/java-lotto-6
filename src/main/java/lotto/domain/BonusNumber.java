package lotto.domain;

import lotto.util.Validator;

public record BonusNumber(int bonusNumber) {

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber(String bonusNumber) {
        this(Validator.validateNumeric(bonusNumber));
    }

    private void validate(int bonusNumber) {
        Validator.validateNumberRange(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
