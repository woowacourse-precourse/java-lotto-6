package lotto.exception;

import java.util.List;

public class InvalidInput {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static String message;

    public void duplicateNumberException(List<Integer> numbers) {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();
        throw new IllegalArgumentException(message);
    }

    public void outOfRangeException(List<Integer> numbers) {
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
