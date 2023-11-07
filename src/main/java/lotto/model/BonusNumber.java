package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberRange;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        isInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber makeBonusNumber(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isInRange(int bonusNumber) {
        if (!(bonusNumber >= NumberRange.LOWEST_NUMBER.getRangeNumber()
                && bonusNumber <= NumberRange.HIGHEST_NUMBER.getRangeNumber())) {
            System.out.println(ErrorMessage.RANGE_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
