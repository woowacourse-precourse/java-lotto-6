package lotto.exception;

import lotto.constant.ExceptionConstant;
import lotto.exception.message.LottoExceptionMessage;

public class LottoException extends IllegalArgumentException implements ExceptionConstant {
    public LottoException(LottoExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }
}

