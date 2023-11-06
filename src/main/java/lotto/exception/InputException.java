package lotto.exception;

import lotto.constant.Error;

public class InputException {

    private static InputException inputException = new InputException();

    private InputException() {
    }

    public static InputException getInputException() {
        return inputException;
    }

    public void is_blank() {
        throw new IllegalArgumentException(Error.IS_BRANK.getMessage());
    }
}
