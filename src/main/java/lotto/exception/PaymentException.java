package lotto.exception;

import lotto.constant.ExceptionConstant;
import lotto.exception.message.PaymentExceptionMessage;

public class PaymentException extends IllegalArgumentException implements ExceptionConstant {
    public PaymentException(PaymentExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }
}
