package lotto.model;

import lotto.util.validate.BonusNumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        BonusNumberValidator.validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
