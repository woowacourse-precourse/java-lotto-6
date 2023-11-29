package lotto.validation;

import static lotto.constant.ValidateMessage.BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.BONUS_NUMBER_IS_NOT_INTEGER;

public class BonusNumberValidator {
    public void isNullOrEmpty(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.length() == 0) {
            BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public int isInteger(String bonusNumber) {
        if (!isNumeric(bonusNumber)) {
            BONUS_NUMBER_IS_NOT_INTEGER.throwException();
        }
        return Integer.parseInt(bonusNumber);
    }

    private boolean isNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
