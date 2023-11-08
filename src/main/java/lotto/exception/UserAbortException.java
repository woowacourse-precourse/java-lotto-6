package lotto.exception;

public class UserAbortException extends RuntimeException {
    public UserAbortException(String message) {
        super(message);
    }
}
