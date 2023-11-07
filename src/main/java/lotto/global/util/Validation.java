package lotto.global.util;

import lotto.global.common.ErrorMessage;

public class Validation {

    public void oneWordAndOver(String input) {
        if (input == "") {
            throw new IllegalArgumentException(ErrorMessage.ONE_WORD_AND_OVER.getMessage());
        }
    }
}
