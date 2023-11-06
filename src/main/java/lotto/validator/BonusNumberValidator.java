package lotto.validator;

import lotto.exception.OutOfNumberRangeException;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static void checkBonusNumberRangeAndThrowException(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < ValidNumber.LOTTO_NUMBER_MIN_RANGE.getNumber() ||
                bonusNumber > ValidNumber.LOTTO_NUMBER_MAX_RANGE.getNumber()) {
            throw new OutOfNumberRangeException();
        }
    }
}
