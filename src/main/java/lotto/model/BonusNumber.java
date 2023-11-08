package lotto.model;

import lotto.constants.ExceptionMessages;
import lotto.constants.LottoConstants;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (isWrongRangeNumber(bonusNumber)) {
            ExceptionMessages.WRONG_RANGE_LOTTO_NUMBERS.throwException();
        }
    }

    private boolean isWrongRangeNumber(Integer bonusNumber) {
        return (bonusNumber < LottoConstants.MINIMUM_LOTTO_NUMBER || bonusNumber > LottoConstants.MAXIMUM_LOTTO_NUMBER);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}

