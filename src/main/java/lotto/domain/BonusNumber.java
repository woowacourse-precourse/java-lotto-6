package lotto.domain;

import lotto.valid.BonusNumberValid;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = BonusNumberValid.validBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}