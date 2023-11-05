package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class DuplicationNumberException extends InputValidationException {

    public DuplicationNumberException() {
        super(ErrorMessage.NUMBERS_DUPLICATE);
    }
}
