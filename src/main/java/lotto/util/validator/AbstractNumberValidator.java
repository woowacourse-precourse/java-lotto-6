package lotto.util.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;

public abstract class AbstractNumberValidator<T> implements InputValidator<T> {

    protected void validateNumberInRange(Integer number) {
        if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE);
        }
    }
}
