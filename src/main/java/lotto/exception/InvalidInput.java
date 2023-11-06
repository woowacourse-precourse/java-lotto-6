package lotto.exception;

import static lotto.constant.CostConstant.UNIT;
import static lotto.constant.LottoConstant.ALLOW_DUPLICATE_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.sql.Struct;
import java.util.Collections;
import java.util.List;
import lotto.view.InputView;

public class InvalidInput {
    private static String message;
    public boolean duplicateNumberException(List<Integer> numbers) {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();

        try {
            for (Integer number : numbers) {
                isDuplicate(numbers, number);
            }
        } catch (IllegalArgumentException e){
            System.out.println(message);
            return false;
        }
        return true;
    }

    public boolean duplicateNumberException(List<Integer> numbers, int bonusNumber) {
        message = ExceptionMessage.DUPLICATE_BONUSE_NUMBER.getMessage();

        try {
            if (numbers.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    public boolean outOfRangeException(List<Integer> numbers) {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();

        try{
            for (Integer number : numbers) {
                isBetweenInRange(number);
            }
        }catch (IllegalArgumentException e){
            System.out.println(message);
            return false;
        }

        return true;
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

    public boolean sizeExceededException(List<Integer> numbers) {
        message = ExceptionMessage.EXCEEDED_LOTTO_SIZE.getMessage();

        if (numbers.size() != LOTTO_SIZE.getValue()) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    public boolean notThousandUnitException(int cost) {
        message = ExceptionMessage.NOT_THOUSAND_UNIT.getMessage();

        if (cost % UNIT.getValue() != 0) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    private static void isDuplicate(List<Integer> numbers, int number) {
        if (Collections.frequency(numbers, number) > ALLOW_DUPLICATE_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isBetweenInRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
