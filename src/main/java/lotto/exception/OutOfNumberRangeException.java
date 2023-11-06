package lotto.exception;

public class OutOfNumberRangeException extends IllegalArgumentException {
    public OutOfNumberRangeException() {
        super(ExceptionMessage.OUT_OF_NUMBER_RANGE_ERROR.getMessage());
    }
}
