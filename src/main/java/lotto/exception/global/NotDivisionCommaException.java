package lotto.exception.global;

import lotto.constants.lotto.ViewElement;
import lotto.constants.message.ErrorMessage;

public class NotDivisionCommaException extends IllegalArgumentException {
    public NotDivisionCommaException() {
        super(String.format(ErrorMessage.WINNING_NUMBERS_DIVISION_COMMA_ERROR.getMessage()
                , ViewElement.COMMA_TEXT, ViewElement.DIVISION_COMMA));
    }
}
