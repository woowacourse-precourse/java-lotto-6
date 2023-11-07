package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_DUPLICATE_ERROR;

public class DuplicateLottoException extends IllegalArgumentException {
    public DuplicateLottoException() { super(LOTTO_DUPLICATE_ERROR); }
}
