package lotto.validator;

import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.NUMERIC;

import lotto.model.constans.LottoSetting;

public class BonusNumberValidator implements Validator {
    public void validate(String bonusNumber) {
        isBlank(bonusNumber);
        checkDigit(bonusNumber);
        checkValidRangeNumber(bonusNumber);
    }

    private void checkDigit(String bonusNumber) {
        if (!bonusNumber.matches(NUMERIC.pattern())) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private void checkValidRangeNumber(String bonusNumber) {
        if (isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBERS_RANGE_ERROR.message());
        }
    }

    private boolean isInvalidRangeNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return (number < LottoSetting.MIN_LOTTO_NUMBER.value() || LottoSetting.MAX_LOTTO_NUMBER.value() < number);
    }
}
