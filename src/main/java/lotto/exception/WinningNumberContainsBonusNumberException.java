package lotto.exception;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_CONTAINS_WINNING_ERROR_MESSAGE;

public class WinningNumberContainsBonusNumberException extends IllegalArgumentException {

    public WinningNumberContainsBonusNumberException() {
        super(BONUS_NUMBER_CONTAINS_WINNING_ERROR_MESSAGE.getMessage());
    }
}
