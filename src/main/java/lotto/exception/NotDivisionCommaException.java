package lotto.exception;

import lotto.constants.ErrorMessage;

public class NotDivisionCommaException extends IllegalArgumentException {
    public NotDivisionCommaException() {
        super(ErrorMessage.WINNING_NUMBERS_DIVISION_COMMA_ERROR.getMessage());
    }
}
