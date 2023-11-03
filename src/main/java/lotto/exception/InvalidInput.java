package lotto.exception;
public class InvalidInput {

    private static String message;

    public void duplicateNumberException() {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void outOfRangeException() {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void notIntegerValueException(String number) {
        message = ExceptionMessage.NOT_INTEGER_VALUE.getMessage();
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
