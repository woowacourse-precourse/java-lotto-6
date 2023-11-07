package lotto.model;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;

import lotto.util.validator.IntegerValidator;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public static BonusNumber from(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validate(String bonusNumber) {
        IntegerValidator.validateInteger(bonusNumber);
        IntegerValidator.validateRange(bonusNumber, MIN_RANGE, MAX_RANGE);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
