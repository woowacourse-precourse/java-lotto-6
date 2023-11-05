package lotto.util.exception.input;

import lotto.util.enums.ErrorMessage;
import lotto.util.exception.parental.InputValidationException;

public class WinningNumbersLengthMatchException extends InputValidationException {

    public WinningNumbersLengthMatchException() {
        super(ErrorMessage.WINNING_NUMBER_LENGTH_NOT_SIX);
    }
}
