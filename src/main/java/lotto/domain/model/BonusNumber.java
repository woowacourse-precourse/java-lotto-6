package lotto.domain.model;

import lotto.domain.validator.Validator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(final int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(final int bonusNumber) {
        Validator.validateNumberInRange(bonusNumber);
    }

    protected int getBonusNumber() {
        return this.bonusNumber;
    }
}
