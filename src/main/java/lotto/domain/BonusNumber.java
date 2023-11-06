package lotto.domain;

import lotto.exception.OutOfNumberRangeException;
import lotto.validator.ValidNumber;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        checkBonusNumberRangeAndThrowException(bonusNumber);
    }

    private void checkBonusNumberRangeAndThrowException(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < ValidNumber.LOTTO_NUMBER_MIN_RANGE.getNumber() ||
                bonusNumber > ValidNumber.LOTTO_NUMBER_MAX_RANGE.getNumber()) {
            throw new OutOfNumberRangeException();
        }
    }
}
