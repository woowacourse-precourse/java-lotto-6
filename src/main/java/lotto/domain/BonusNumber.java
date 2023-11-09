package lotto.domain;

import lotto.exception.OutOfNumberRangeException;

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
        if (bonusNumber < LottoProperty.LOTTO_NUMBER_MIN_RANGE.getNumber() ||
                bonusNumber > LottoProperty.LOTTO_NUMBER_MAX_RANGE.getNumber()) {
            throw new OutOfNumberRangeException();
        }
    }
}
