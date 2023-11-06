package lotto.error.exception;

public class InvalidStateException extends IllegalStateException {
    private final String message;
    private final Object[] params;

    public InvalidStateException(String message, Object... params) {
        this.message = message;
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getParams() {
        return params;
    }
}
