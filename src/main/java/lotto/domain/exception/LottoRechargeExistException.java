package lotto.domain.exception;

import lotto.common.LottoException;

public class LottoRechargeExistException extends LottoException {
    private static final String ERROR_MESSAGE = "로또 구매 금액은 로또 가격의 배수여야 합니다.";

    public LottoRechargeExistException() {
        super(ERROR_MESSAGE);
    }
}
