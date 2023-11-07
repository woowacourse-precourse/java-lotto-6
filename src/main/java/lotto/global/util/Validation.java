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
}
