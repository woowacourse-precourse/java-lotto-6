package lotto.domain;

import lotto.utils.Validation;

public record BonusNumber(int bonusNumber) {

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, 1, 45);
    }
}
