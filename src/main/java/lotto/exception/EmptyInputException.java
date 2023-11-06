package lotto.exception;

import static lotto.message.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
    }
}
