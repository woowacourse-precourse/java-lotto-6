package lotto.exception;

import static lotto.constant.ErrorMessage.CHARACTER_INPUT_ERROR_MESSAGE;

public class NonNumericInputException extends IllegalArgumentException {

    public NonNumericInputException() {
        super(CHARACTER_INPUT_ERROR_MESSAGE.getMessage());
    }
}
