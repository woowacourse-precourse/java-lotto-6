package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_IN_RANGE_ERROR;

public class LottoNumOutOfRangeException extends IllegalArgumentException {
    public LottoNumOutOfRangeException() { super(LOTTO_IN_RANGE_ERROR); }
}
