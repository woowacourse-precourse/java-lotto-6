package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer toInt() {
        return bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isInRange(int bonusNumber) {
        return bonusNumber >= LottoConstant.MIN_VALUE.getValue() && bonusNumber <= LottoConstant.MAX_VALUE.getValue();
    }
}
