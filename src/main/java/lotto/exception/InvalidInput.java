package lotto.exception;
public class InvalidInput {

    public void duplicateNumberException() {
        String message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void outOfRangeException() {
        String message = ExceptionMessage.OUT_OF_RANGE.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void  notIntegerValueException(){
        String message = ExceptionMessage.NOT_INTEGER_VALUE.getMessage();
        throw new IllegalArgumentException(message);
    }
}
