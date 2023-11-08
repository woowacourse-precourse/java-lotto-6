package lotto.model;

import lotto.util.Constant;
import lotto.util.ErrorMessage;
import lotto.util.validate.ValidationManager;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        ValidationManager.validateInput(bonusNumber);
        validateValidRangeNumber(Integer.parseInt(bonusNumber));

        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateValidRangeNumber(int bonusNumber) {
        if (isNotValidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isNotValidRangeNumber(int bonusNumber) {
        return bonusNumber < Constant.LOTTO_NUMBER_MIN || bonusNumber > Constant.LOTTO_NUMBER_MAX;
    }
}
