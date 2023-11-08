package lotto.model;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        BonusNumberValidator.validateBonusNumberBound(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber getInstance(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
