package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.INVALID_LOTTO_RANGE;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {

    public InvalidLottoNumberRangeException() {
        super(INVALID_LOTTO_RANGE);
    }
}
