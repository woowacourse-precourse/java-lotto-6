package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        this.bonusNumber = inputBonusNumber;
    }

    public void validateBonusNumber(int inputBonusNumber) {
        validateBonusNumberRange(inputBonusNumber);
    }

    private void validateBonusNumberRange(int inputBonusNumber) {
        if (inputBonusNumber < Constants.LOTTO_MIN_NUMBER || inputBonusNumber > Constants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_INVALID_ERROR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
