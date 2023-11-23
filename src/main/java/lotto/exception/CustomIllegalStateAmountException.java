package lotto.exception;

public class CustomIllegalStateAmountException extends IllegalStateException {

    public CustomIllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
