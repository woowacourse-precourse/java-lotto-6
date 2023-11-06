package lotto.domain;

import lotto.util.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    BonusNumber(String number) {
        new BonusNumberValidator(number);
        this.bonusNumber = Integer.parseInt(number);
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
