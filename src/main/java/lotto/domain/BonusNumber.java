package lotto.domain;

import lotto.valid.BonusNumberValid;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(WinNumber winNumber, String bonusNumber) {
        this.bonusNumber = BonusNumberValid.validBonusNumber(winNumber, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}