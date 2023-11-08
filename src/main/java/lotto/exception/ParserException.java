package lotto.exception;

import lotto.constant.ExceptionConstant;
import lotto.exception.message.ParserExceptionMessage;

public class ParserException extends IllegalArgumentException implements ExceptionConstant {
    public ParserException(ParserExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }
}

