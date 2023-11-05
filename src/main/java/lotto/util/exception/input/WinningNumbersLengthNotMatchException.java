package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class WinningNumbersLengthNotMatchException extends InputValidationException {

    public WinningNumbersLengthNotMatchException() {
        super(ErrorMessage.WINNING_NUMBER_LENGTH_NOT_SIX);
    }
}
