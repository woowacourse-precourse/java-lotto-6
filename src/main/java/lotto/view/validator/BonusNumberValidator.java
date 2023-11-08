package lotto.view.validator;

import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class BonusNumberValidator {
    public void validate(final String bonusNumber) {
        isNotEmpty(bonusNumber);
        isNumeric(bonusNumber);
        isNotExceedInputRange(bonusNumber);
    }

    private void isNotEmpty(final String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNumeric(final String bonusNumber) {
        try {
            Long.parseLong(bonusNumber);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.BONUS_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isNotExceedInputRange(final String bonusNumber) {
        if (exceedInputRange(bonusNumber)) {
            throw LottoInputException.of(LottoInputExceptionMessage.BONUS_NUMBER_INPUT_EXCEED_INPUT_RANGE);
        }
    }

    private boolean exceedInputRange(final String bonusNumber) {
        return Long.parseLong(bonusNumber) > Integer.MAX_VALUE || Long.parseLong(bonusNumber) < Integer.MIN_VALUE;
    }
}