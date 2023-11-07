package lotto;

import java.util.List;

public class Validation {
    public void isAllNumber(String string) {
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException(Messages.ALL_NUMBER_ERROR.getMessage());
        }
    }

    public void isDivisibleByThousand(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(Messages.DIVISIBLE_BY_THOUSAND_ERROR.getMessage());
        }
    }

    public void isBetweenRangeNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Messages.BETWEEN_RANGE_ERROR.getMessage());
        }
    }

    public void isNotDuplicated(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(Messages.DUPLICATED_ERROR.getMessage());
        }
    }
}
