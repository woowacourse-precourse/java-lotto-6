package lotto.exception;
public class InvalidInputException {

    public void duplicateNumberException() {
        String message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void outOfRangeException() {
        String message = ExceptionMessage.OUT_OF_RANGE.getMessage();
        throw new IllegalArgumentException(message);
    }
}
