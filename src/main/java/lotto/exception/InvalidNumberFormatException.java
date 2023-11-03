package lotto.exception;

public class InvalidNumberFormatException extends NumberFormatException {
    private static final String ERROR = "[ERROR] ";

    public InvalidNumberFormatException(String message) {
        super(ERROR + message);
    }
}
