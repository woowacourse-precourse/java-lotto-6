package lotto.global.util;

import lotto.global.common.ErrorMessage;

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
}
