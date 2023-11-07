package lotto.global.util;

import lotto.global.common.ErrorMessage;

import java.util.List;

public class Validation {
    private ErrorMessage errorMessage;

    public void oneWordAndOver(String input) {
        if (input == "") {
            errorMessage = ErrorMessage.ONE_WORD_AND_OVER;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void multipleOfThousand(int price) {
        if (price <= 0 || price % 1000 != 0) {
            errorMessage = ErrorMessage.MULTIPLE_OF_1000;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void hundredThousandOrUnder(int price) {
        if (price > 100000) {
            errorMessage = ErrorMessage.HUNDRED_THOUSAND_OR_UNDER;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isInRangeOf1To45(int number) {
        if (number < 1 || number > 45) {
            errorMessage = ErrorMessage.RANGE_1_45;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            errorMessage = ErrorMessage.SIX_NUMBERS;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void hasDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            errorMessage = ErrorMessage.DUPLICATE;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public void hasSameNumberInList(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            errorMessage = ErrorMessage.DUPLICATE_BONUS;
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
