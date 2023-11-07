package lotto.domain;

import lotto.constants.LottoRules;
import lotto.utils.Validation;

public record BonusNumber(int bonusNumber) {

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, LottoRules.MIN_LOTTO_NUMBER.getValue(), LottoRules.MAX_LOTTO_NUMBER.getValue());
    }
}
