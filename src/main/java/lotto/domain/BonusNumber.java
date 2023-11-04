package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        BonusNumberValidator.validateBonusNumber(number);
        this.number = number;
    }


}
