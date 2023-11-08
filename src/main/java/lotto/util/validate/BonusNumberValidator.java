package lotto.util.validate;

import lotto.util.Constant;
import lotto.util.ErrorMessage;

public class BonusNumberValidator {

    public static void validate(String bonusNumber) {
        ValidationManager.validateInput(bonusNumber);
        checkValidRangeNumber(Integer.parseInt(bonusNumber));
    }

    private static void checkValidRangeNumber(int bonusNumber) {
        if (isNotValidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean isNotValidRangeNumber(int bonusNumber) {
        return bonusNumber < Constant.LOTTO_NUMBER_MIN || bonusNumber > Constant.LOTTO_NUMBER_MAX;
    }
}
