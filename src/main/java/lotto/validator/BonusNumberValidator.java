package lotto.validator;

import static lotto.validator.constants.ExceptionMessage.*;

import lotto.model.constans.LottoSetting;

public class BonusNumberValidator {
    public void validate(String bonusNumber) {
        checkBlank(bonusNumber);
        checkDigit(bonusNumber);
        checkValidRangeNumber(bonusNumber);
    }

    private void checkBlank(String bonusNumber) {
        if (isBlank(bonusNumber)) {
            throw new IllegalArgumentException(BLANK_ERROR.message());
        }
    }

    private boolean isBlank(String bonusNumber) {
        return bonusNumber == null || bonusNumber.isBlank();
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
