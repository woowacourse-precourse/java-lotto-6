package lotto.exception;

public class CustomNumberFormatAmountException extends NumberFormatException {

    public CustomNumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
