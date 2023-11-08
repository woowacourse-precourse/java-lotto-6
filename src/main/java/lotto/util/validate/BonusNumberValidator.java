package lotto.util.validate;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

public class BonusNumberValidator {

    public static void validate(String bonusNumber) {
        InputValidator.validateInput(bonusNumber);
        checkValidRangeNumber(Integer.parseInt(bonusNumber));
    }

    private static void checkValidRangeNumber(int bonusNumber) {
        if (isNotValidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean isNotValidRangeNumber(int bonusNumber) {
        return bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX;
    }
}
