package lotto.domain.model;

import lotto.domain.validator.Validator;

public class BonusNumber {

    int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        Validator.validateNumberInRange(bonusNumber);
    }

    protected int getBonusNumber() {
        return this.bonusNumber;
    }
}
