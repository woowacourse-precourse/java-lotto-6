package lotto.exception;

public class InvalidPaymentAmountException extends IllegalArgumentException {
    public InvalidPaymentAmountException(String exceptionCode) {
        super(exceptionCode);
    }
}
