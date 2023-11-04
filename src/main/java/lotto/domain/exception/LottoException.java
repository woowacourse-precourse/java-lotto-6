package lotto.domain.exception;

import lotto.global.exception.base.DefaultException;

public class LottoException extends DefaultException {
    public LottoException(LottoError error) {
        super(error);
    }
}
