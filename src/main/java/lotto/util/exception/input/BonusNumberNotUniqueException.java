package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class BonusNumberNotUniqueException extends InputValidationException {
    public BonusNumberNotUniqueException() {
        super(ErrorMessage.BONUS_NUMBER_IS_NOT_UNIQUE);
    }
}
