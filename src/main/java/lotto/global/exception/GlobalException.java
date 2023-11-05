package lotto.global.exception;

import lotto.global.exception.base.LottoGameException;

public class GlobalException extends LottoGameException {

    public GlobalException(GlobalError error) {
        super(error);
    }
}
