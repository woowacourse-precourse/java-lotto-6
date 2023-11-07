package lotto.view.validator;

import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class BonusNumberValidator {
    public void validate(String bonusNumber) {
        isNotEmpty(bonusNumber);
        isNotNumeric(bonusNumber);
        isNotExceedInputRange(bonusNumber);
    }

    private void isNotEmpty(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNotNumeric(String bonusNumber) {
        try {
            Long.parseLong(bonusNumber);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.BONUS_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isNotExceedInputRange(String bonusNumber) {
        if (exceedInputRange(bonusNumber)) {
            throw LottoInputException.of(LottoInputExceptionMessage.BONUS_NUMBER_INPUT_EXCEED_INPUT_RANGE);
        }
    }

    private boolean exceedInputRange(String bonusNumber) {
        return Long.parseLong(bonusNumber) > Integer.MAX_VALUE || Long.parseLong(bonusNumber) < Integer.MIN_VALUE;
    }
}