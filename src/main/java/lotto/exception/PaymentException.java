package lotto.exception;

public class PaymentException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public PaymentException(PaymentExceptionMessage errorMessage) {
        super(ERROR_MESSAGE_PREFIX + errorMessage.getMessage());
    }
}
