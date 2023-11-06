package lotto.exception;

public class EmptyInputException extends IllegalArgumentException {
    public EmptyInputException() {
        super(ExceptionMessage.EMPTY_INPUT_ERROR.getMessage());
    }
}
