package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.message.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(final int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(final int bonusNumber) {
        if (bonusNumber < LottoRule.LOTTO_MIN_NUMBER.getValue()
                || bonusNumber > LottoRule.LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_OF_RANGE.getValue());
        }
    }

    public boolean contains(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
