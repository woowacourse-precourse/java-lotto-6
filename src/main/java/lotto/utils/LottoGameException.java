package lotto.utils;

import lotto.constants.ExceptionMessage;

public class LottoGameException extends IllegalArgumentException {
    public LottoGameException(ExceptionMessage ExceptionMessage, Exception exception) {
        super(ExceptionMessage.getMessage(), exception);
    }

    public LottoGameException(ExceptionMessage ExceptionMessage) {
        super(ExceptionMessage.getMessage());
    }

    public static LottoGameException withMessageAndException(ExceptionMessage ExceptionMessage, Exception exception) {
        return new LottoGameException(ExceptionMessage, exception);
    }

    public static LottoGameException withMessage(ExceptionMessage ExceptionMessage) {
        return new LottoGameException(ExceptionMessage);
    }
}

