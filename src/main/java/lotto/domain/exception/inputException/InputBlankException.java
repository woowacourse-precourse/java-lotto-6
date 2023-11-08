package lotto.domain.exception.inputException;

import lotto.view.ExceptionMessage;

public class InputBlankException extends IllegalArgumentException {

    public InputBlankException() {
        super(ExceptionMessage.INPUT_BLANK_EXCEPTION.getErrorMessage());
    }
}
