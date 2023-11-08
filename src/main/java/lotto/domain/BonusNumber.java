package lotto.domain;

import lotto.util.LottoValidator;
import lotto.util.Validator;

public record BonusNumber(int bonusNumber) {

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber(String bonusNumber) {
        this(Validator.validateNumeric(bonusNumber));
    }

    private void validate(int bonusNumber) {
        LottoValidator.validateNumberRange(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
