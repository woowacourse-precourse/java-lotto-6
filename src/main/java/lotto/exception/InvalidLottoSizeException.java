package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_SIZE_ERROR;

public class InvalidLottoSizeException extends IllegalArgumentException {
    public InvalidLottoSizeException() { super(LOTTO_SIZE_ERROR); }
}
