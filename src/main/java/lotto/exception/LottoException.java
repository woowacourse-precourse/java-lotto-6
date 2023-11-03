package lotto.exception;

import static lotto.constants.ErrorMessage.ERROR_PREFIX;

import lotto.constants.ErrorMessage;

public class LottoException extends IllegalArgumentException {
    private LottoException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static LottoException of(ErrorMessage errorConstant) {
        return new LottoException(errorConstant.getMessage());
    }
}
