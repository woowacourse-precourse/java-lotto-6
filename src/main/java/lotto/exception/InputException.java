package lotto.exception;

import lotto.constant.Error;

public class InputException {

    private static InputException inputException = new InputException();

    private InputException() {
    }

    public static InputException getInputException() {
        return inputException;
    }

    public void isBlank() {
        throw new IllegalArgumentException(Error.IS_BRANK.getMessage());
    }

    public void isNotNaturalNumber() {
        throw new IllegalArgumentException(Error.ABLE_NUMBER.getMessage());
    }
}
