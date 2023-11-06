package lotto.error.exception;

public class InvalidInputException extends IllegalArgumentException {
    private final String message;
    private final Object[] params;

    public InvalidInputException(String message, Object... params) {
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
