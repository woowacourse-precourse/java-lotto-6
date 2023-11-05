package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class DuplicationNumberException extends InputValidationException {

    public DuplicationNumberException() {
        super(ErrorMessage.DUPLICATE_NUMBERS);
    }
}
