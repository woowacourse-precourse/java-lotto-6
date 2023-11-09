package lotto.exception;

public class NotIntegerInputException extends IllegalArgumentException {
    public NotIntegerInputException() {
        super(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
    }
}
