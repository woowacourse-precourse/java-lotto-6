package lotto.view.validator;

import lotto.view.exception.BonusNumberInputException;
import lotto.view.message.exception.BonusNumberInputExceptionMessage;

public class BonusNumberInputValidator {
    public void validate(final String bonusNumber) {
        isNotEmpty(bonusNumber);
        isNumeric(bonusNumber);
        isNotExceedInputRange(bonusNumber);
    }

    private void isNotEmpty(final String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw BonusNumberInputException.of(BonusNumberInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNumeric(final String bonusNumber) {
        try {
            Long.parseLong(bonusNumber);
        } catch (NumberFormatException e) {
            throw BonusNumberInputException.of(BonusNumberInputExceptionMessage.BONUS_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isNotExceedInputRange(final String bonusNumber) {
        if (exceedInputRange(bonusNumber)) {
            throw BonusNumberInputException.of(BonusNumberInputExceptionMessage.BONUS_NUMBER_INPUT_EXCEED_INPUT_RANGE);
        }
    }

    private boolean exceedInputRange(final String bonusNumber) {
        return Long.parseLong(bonusNumber) > Integer.MAX_VALUE || Long.parseLong(bonusNumber) < Integer.MIN_VALUE;
    }
}