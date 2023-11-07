package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        BonusNumberValidator.validateMinNumber(bonusNumber);
        BonusNumberValidator.validateMaxNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
