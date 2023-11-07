package lotto.exception;

public class CustomStateException extends IllegalStateException {

    public CustomStateException(String message) {
        super(ExceptionMessageUtil.getErrorMessage(message));
    }
}
