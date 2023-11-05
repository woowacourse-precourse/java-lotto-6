package lotto.exception;

public class InputException extends IllegalArgumentException {

    public InputException(final InputErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}