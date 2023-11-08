package lotto.exception;

import static lotto.constant.CostConstant.UNIT;
import static lotto.constant.LottoConstant.ALLOW_DUPLICATE_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.exception.ExceptionMessage.DUPLICATE_BONUSE_NUMBER;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class InvalidInput {
    private static final int ZERO = 0;
    private static final char COMMA = ',';
    private static final int REQUIRED_COMMA_NUM = 5;
    private static String message;

    public boolean commaSeparatedFormatException(String numbers) {
        message = ExceptionMessage.NO_COMMA.getMessage();
        if (countCommas(numbers) != REQUIRED_COMMA_NUM) {
            System.out.println(message);
            return true;
        }
        return false;
    }


    public boolean duplicateNumbersException(List<Integer> numbers) {
        message = ExceptionMessage.DUPLICATE_NUMBER.getMessage();

        for (Integer number : numbers) {
            if (isDuplicate(numbers, number)) {
                System.out.println(message);
                return true;
            }
        }
        return false;
    }
    public boolean duplicateNumberException(Lotto winningLottoNumbers, int bonusNumber) {
        if (winningLottoNumbers.checkContainsSameNumber(bonusNumber)) {
            System.out.println(DUPLICATE_BONUSE_NUMBER.getMessage());
            return true;
        }
        return false;
    }

    public boolean outOfRangeNumbersException(List<Integer> numbers) {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();

        for (Integer number : numbers) {
            if (outOfRangeNumberException(number)) {
                return true;
            }
        }

        return false;
    }

    public boolean outOfRangeNumberException(int number) {
        message = ExceptionMessage.OUT_OF_RANGE.getMessage();

        if (!isBetweenInRange(number)) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    public boolean notIntegerValueException(String number) {
        message = ExceptionMessage.NOT_INTEGER_VALUE.getMessage();

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(message);
            return true;
        }

        return false;
    }

    public boolean sizeExceededException(List<Integer> numbers) {
        message = ExceptionMessage.EXCEEDED_LOTTO_SIZE.getMessage();

        if (numbers.size() != LOTTO_SIZE.getValue()) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    public boolean notThousandUnitException(int cost) {
        message = ExceptionMessage.NOT_THOUSAND_UNIT.getMessage();

        if (cost % UNIT.getValue() != ZERO) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    private int countCommas(String numbers) {
        return (int) numbers.chars().filter(ch -> ch == COMMA).count();
    }
    private boolean isDuplicate(List<Integer> numbers, int number) {
        if (Collections.frequency(numbers, number) > ALLOW_DUPLICATE_NUMBER_COUNT.getValue()) {
            return true;
        }
        return false;
    }

    private boolean isBetweenInRange(int number) {
        if (number >= MIN_NUMBER.getValue() && number <= MAX_NUMBER.getValue()) {
            return true;
        }
        return false;
    }

}
