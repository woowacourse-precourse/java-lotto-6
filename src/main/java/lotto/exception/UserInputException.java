package lotto.exception;

import static lotto.message.ErrorMessage.INVALID_INPUT;

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