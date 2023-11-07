package lotto.exception;

import lotto.constant.Error;

public class InputException extends IllegalArgumentException{

    private static InputException inputException = new InputException();

    public InputException() {
    }

    private InputException(Error error) {
        super(error.getMessage());
    }

    public static InputException getInputException() {
        return inputException;
    }

    public void isBlank() {
        throw new IllegalArgumentException(Error.IS_BRANK.getMessage());
    }

    public InputException isNotNaturalNumber(Error error) {
        System.out.println(error.getMessage());
        throw new IllegalArgumentException(error.getMessage());
    }
}
