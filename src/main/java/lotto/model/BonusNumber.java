package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberRange;

public class BonusNumber {
    int bonusNumber;

    BonusNumber(int bonusNumber) {
        isInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isInRange(int bonusNumber) {
        if (!(bonusNumber >= NumberRange.LOWEST_NUMBER.getRangeNumber()
                && bonusNumber <= NumberRange.HIGHEST_NUMBER.getRangeNumber())) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
