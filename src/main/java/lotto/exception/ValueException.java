package lotto.exception;

import static lotto.utils.NumberOrNot.isNumber;

public class ValueException {
    public static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalStateException("다시 입력하세요");
        }
    }
}


