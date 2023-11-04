package lotto.exception;

import java.util.Collections;
import java.util.List;

public class InvalidInput {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int ALLOW_DUPLICATE_NUMBER_COUNT = 1;
    private static final int LOTTO_SIZE = 6;

    private static String message;

    public void duplicateNumberException(List<Integer> numbers) {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();
        for (Integer number : numbers) {
            isDuplicate(numbers, number);
        }
    }

    public void outOfRangeException(List<Integer> numbers) {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();
        for (Integer number : numbers) {
            isBetweenInRange(number);
        }
    }
    public void notIntegerValueException(String number) {
        message = ExceptionMessage.NOT_INTEGER_VALUE.getMessage();
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(message);
        }
    }

    public void sizeExceededException(List<Integer> numbers) {
        message = ExceptionMessage.EXCEEDED_LOTTO_SIZE.getMessage();
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void isDuplicate(List<Integer> numbers, Integer number) {
        if (Collections.frequency(numbers, number) > ALLOW_DUPLICATE_NUMBER_COUNT) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void isBetweenInRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(message);
        }
    }
}
