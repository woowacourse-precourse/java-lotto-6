package lotto.exception;

public class CustomArgumentException extends IllegalArgumentException {

    public CustomArgumentException(String message) {
        super(ExceptionMessageUtil.getErrorMessage(message));
    }
}
