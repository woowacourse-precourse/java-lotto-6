package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.INVALID_PLAYER_AMOUNT;

public class InvalidMinPlayAmountException extends IllegalArgumentException {
    public InvalidMinPlayAmountException() {
        super(INVALID_PLAYER_AMOUNT);
    }
}
