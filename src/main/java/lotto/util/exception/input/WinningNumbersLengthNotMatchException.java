package lotto.util.exception;

import lotto.util.enums.ErrorMessage;

public class WinningNumbersLengthNotMatchException extends InputValidationException{

    public WinningNumbersLengthNotMatchException() {
        super(ErrorMessage.WINNING_NUMBER_LENGTH_NOT_SIX);
    }
}
