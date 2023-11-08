package lotto.domain.exception;

import lotto.global.exception.base.LottoGameException;

public class LottoException extends LottoGameException {
    public LottoException(LottoError error) {
        super(error);
    }
}
