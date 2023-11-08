package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.Numbers;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        checkValidateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void checkValidateRange(int bonusNumber) {
        if (bonusNumber < Numbers.RANGE_MIN_NUMBER || bonusNumber > Numbers.RANGE_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
