package lotto.exception;

import static lotto.message.ErrorMessage.INVALID_INPUT;

import lotto.message.ErrorMessage;

public class UserInputException extends IllegalArgumentException {

    public UserInputException() {
        super(INVALID_INPUT.getMessage());
    }

    public UserInputException(String s) {
        super(s);
    }
    public UserInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }


}