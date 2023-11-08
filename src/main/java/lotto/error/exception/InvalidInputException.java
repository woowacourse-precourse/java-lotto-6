package lotto.error.exception;

public class InvalidInputException extends IllegalArgumentException {
    private final String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
