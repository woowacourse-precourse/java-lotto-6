package lotto.global.util;

import lotto.global.common.ErrorMessage;

import java.util.List;

public class Validation {

    public void oneWordAndOver(String input) {
        if (input == "") {
            throw new IllegalArgumentException(ErrorMessage.ONE_WORD_AND_OVER.getMessage());
        }
    }

    public void multipleOfThousand(int price) {
        if (price <= 0 || price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLE_OF_1000.getMessage());
        }
    }

    public void hundredThousandOrUnder(int price) {
        if (price > 100000) {
            throw new IllegalArgumentException(ErrorMessage.HUNDRED_THOUSAND_OR_UNDER.getMessage());
        }
    }

    public void isInRangeOf1To45(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_1_45.getMessage());
        }
    }

    public void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIX_NUMBERS.getMessage());
        }
    }

    public void hasDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }

    public void hasSameNumberInList(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS.getMessage());
        }
    }
}
