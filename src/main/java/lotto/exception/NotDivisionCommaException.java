package lotto.exception;

import lotto.constants.ErrorMessage;
import lotto.constants.ViewElement;

public class NotDivisionCommaException extends IllegalArgumentException {
    public NotDivisionCommaException() {
        super(String.format(ErrorMessage.WINNING_NUMBERS_DIVISION_COMMA_ERROR.getMessage()
                , ViewElement.COMMA_TEXT, ViewElement.DIVISION_COMMA));
    }
}
