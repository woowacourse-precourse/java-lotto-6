package lotto.domain.exception;

import lotto.common.LottoException;

public class IllegalLottoPriceException extends LottoException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 0보다 큰 숫자여야 합니다.";

    public IllegalLottoPriceException() {
        super(ERROR_MESSAGE);
    }
}
