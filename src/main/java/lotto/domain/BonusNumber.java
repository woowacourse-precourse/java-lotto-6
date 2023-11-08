package lotto.domain;

import lotto.constants.LottoRules;
import lotto.utils.Validation;

public record BonusNumber(int bonusNumber) {

    public BonusNumber {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, LottoRules.MIN_LOTTO_NUMBER.getValue(), LottoRules.MAX_LOTTO_NUMBER.getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BonusNumber other = (BonusNumber) obj;
        return bonusNumber == other.bonusNumber;
    }
}
