package lotto.model;

import lotto.constants.ErrorMessages;
import lotto.constants.LottoNumberLimits;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        checkNumberRange(bonusNumber);
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber < LottoNumberLimits.MIN_NUMBER || bonusNumber > LottoNumberLimits.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
