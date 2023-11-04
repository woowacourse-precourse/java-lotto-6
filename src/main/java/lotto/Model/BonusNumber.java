package lotto.Model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberRange;

public class BonusNumber {
    int bonusNumber;
    NumberRange lowestNumber;
    NumberRange highestNumber;
    ErrorMessage notInRange = ErrorMessage.RANGE_ERROR_MESSAGE;

    BonusNumber(int bonusNumber, NumberRange lowestNumber, NumberRange highestNumber) {
        isInRange();
        this.bonusNumber = bonusNumber;
        this.lowestNumber = lowestNumber;
        this.highestNumber = highestNumber;
    }

    private void isInRange() {
        if (!(bonusNumber >= lowestNumber.getRangeNumber()
                && bonusNumber <= highestNumber.getRangeNumber())) {
            throw new IllegalArgumentException(notInRange.getErrorMessage());
        }
    }
}
