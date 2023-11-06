package lotto.exception;

import static lotto.exception.message.ErrorMessage.INVALID_LOTTO_SIZE_ERROR_MESSAGE;

public class InvalidLottoSizeException extends IllegalArgumentException {

    public InvalidLottoSizeException() {
        super(INVALID_LOTTO_SIZE_ERROR_MESSAGE.getMessage());
    }
}
