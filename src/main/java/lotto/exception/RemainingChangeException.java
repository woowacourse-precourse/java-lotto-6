package lotto.exception;

import static lotto.constant.ErrorMessage.REMAINING_CHANGE_ERROR_MESSAGE;

public class RemainingChangeException extends IllegalArgumentException {

    public RemainingChangeException() {
        super(REMAINING_CHANGE_ERROR_MESSAGE.getMessage());
    }
}
