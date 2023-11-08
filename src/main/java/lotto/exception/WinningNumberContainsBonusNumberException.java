package lotto.exception;

import static lotto.exception.message.ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER_ERROR_MESSAGE;

public class WinningNumberContainsBonusNumberException extends IllegalArgumentException {

    public WinningNumberContainsBonusNumberException() {
        super(WINNING_NUMBERS_CONTAINS_BONUS_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
