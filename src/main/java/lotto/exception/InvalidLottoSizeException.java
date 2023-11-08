package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.INVALID_LOTTO_SIZE;

public class InvalidLottoSizeException extends IllegalArgumentException {

    public InvalidLottoSizeException() {
        super(INVALID_LOTTO_SIZE);
    }
}
