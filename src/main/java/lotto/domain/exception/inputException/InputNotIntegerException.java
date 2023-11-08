package lotto.domain.exception.inputException;

import lotto.view.ExceptionMessage;

public class InputNotIntegerException extends IllegalArgumentException {

    public InputNotIntegerException() {
        super(ExceptionMessage.NOT_INTEGER_EXCEPTION.getErrorMessage());
    }
}
