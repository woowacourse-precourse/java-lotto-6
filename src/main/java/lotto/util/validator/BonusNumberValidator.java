package lotto.util.validator;

import lotto.util.exception.ErrorCode;

public class BonusNumberValidator {
    private void validateNullorEmpty(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_BONUS_NUMBER.getMessage());
        }
    }
}
