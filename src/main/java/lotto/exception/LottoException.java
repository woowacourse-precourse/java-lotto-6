package lotto.exception;

import static lotto.constants.ErrorConstants.ERROR_PREFIX;

import lotto.constants.ErrorConstants;

public class LottoException extends IllegalArgumentException {
    private LottoException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static LottoException of(ErrorConstants errorConstant) {
        return new LottoException(errorConstant.getMessage());
    }
}
