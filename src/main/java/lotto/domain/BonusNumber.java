package lotto.domain;

import lotto.service.NumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        NumberValidator numberValidator = new NumberValidator();
        numberValidator.validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
