package lotto.exception;

import static lotto.constant.CostConstant.UNIT;
import static lotto.constant.LottoConstant.ALLOW_DUPLICATE_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.Collections;
import java.util.List;

public class InvalidInput {
    private static String message;

    public void duplicateNumberException(List<Integer> numbers) {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();

        for (Integer number : numbers) {
            isDuplicate(numbers, number);
        }
    }

    public void duplicateNumberException(List<Integer> numbers, int bonusNumber) {
        message = ExceptionMessage.DUPLICATE_BONUSE_NUMBER.getMessage();

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(message);
        }
    }

    public void outOfRangeException(List<Integer> numbers) {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();

        for (Integer number : numbers) {
            isBetweenInRange(number);
        }
    }
    public boolean notIntegerValueException(String number) {
        message = ExceptionMessage.NOT_INTEGER_VALUE.getMessage();

        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(message);
            return false;
        }
    }

    public void sizeExceededException(List<Integer> numbers) {
        message = ExceptionMessage.EXCEEDED_LOTTO_SIZE.getMessage();

        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(message);
        }
    }

    public void notThousandUnitException(int cost) {
        message = ExceptionMessage.NOT_THOUSAND_UNIT.getMessage();

        if (cost % UNIT.getValue() != 0) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void isDuplicate(List<Integer> numbers, int number) {
        if (Collections.frequency(numbers, number) > ALLOW_DUPLICATE_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void isBetweenInRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(message);
        }
    }
}
