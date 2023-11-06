package lotto.exception;

import static lotto.message.ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE;

public class DuplicateLottoNumberException extends IllegalArgumentException {

    public DuplicateLottoNumberException() {
        super(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
