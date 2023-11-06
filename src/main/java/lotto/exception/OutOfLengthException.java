package lotto.exception;

public class OutOfLengthException extends IllegalArgumentException {
    public OutOfLengthException() {
        super(ExceptionMessage.OUT_OF_LENGTH_LOTTO_NUMBER_ERROR.getMessage());
    }
}
