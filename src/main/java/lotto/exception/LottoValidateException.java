package lotto.exception;

import lotto.util.LottoValidate;

public class LottoValidateException extends IllegalArgumentException {


    public LottoValidateException(String message) {
        super(LottoExceptionType.ERROR_PREFIX.getMessage() + message);
    }
}
