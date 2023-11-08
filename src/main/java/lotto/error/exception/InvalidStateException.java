package lotto.error.exception;

public class InvalidStateException extends IllegalStateException {
    private final String message;

    public InvalidStateException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
