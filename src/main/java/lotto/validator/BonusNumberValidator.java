package lotto.validator;

import static lotto.validator.constants.ExceptionMessage.*;

import lotto.model.constans.LottoSetting;

public class BonusNumberValidator implements Validator {
    public void validate(String bonusNumber) {
        isBlank(bonusNumber);
        checkDigit(bonusNumber);
        checkValidRangeNumber(bonusNumber);
    }

    private void checkDigit(String bonusNumber) {
        if (isNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private boolean isNotDigit(String bonusNumber) {
        return !bonusNumber.chars()
                .allMatch(Character::isDigit);
    }

    private void checkValidRangeNumber(String bonusNumber) {
        if (isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_ERROR.message());
        }
    }

    private boolean isInvalidRangeNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return (number < LottoSetting.MIN_LOTTO_NUMBER.value() || LottoSetting.MAX_LOTTO_NUMBER.value() < number);
    }
}
