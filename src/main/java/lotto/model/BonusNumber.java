package lotto.model;

import lotto.validation.LottoNumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        LottoNumberValidator.validateBonusNumber(bonusNumber);
    }
}
