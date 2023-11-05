package lotto.model;


import static lotto.util.validators.BonusNumberValidator.validateBonusNumber;

import lotto.model.WinningNumbers;

public class BonusNumber {
    private final Integer value;

    public BonusNumber(String value, WinningNumbers winningNumbers) {
        validateBonusNumber(value, winningNumbers);
        this.value = Integer.valueOf(value);
    }

    public Integer getValue() {
        return this.value;
    }
}
