package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class BonusNumberNotUniqueException extends InputValidationException {
    public BonusNumberNotUniqueException() {
        super(ErrorMessage.BONUS_NUMBER_IS_NOT_UNIQUE);
    }
}
