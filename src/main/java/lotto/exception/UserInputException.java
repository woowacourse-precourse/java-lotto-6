package lotto.exception;

public class UserInputException extends IllegalArgumentException {

    public UserInputException() {
        super();
    }

    public UserInputException(String s) {
        super(s);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}