package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = validateIsCorrectNumberRange(validateIsCorrectNumberFormat(bonusNumber));
    }

    private int validateIsCorrectNumberFormat(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.WRONG_BONUS_NUMBER_FORMAT);
        }
    }

    private int validateIsCorrectNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new CustomException(ErrorMessage.WRONG_BONUS_NUMBER_RANGE);
        }
        return bonusNumber;

    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
