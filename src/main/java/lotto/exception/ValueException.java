package lotto.exception;

import static lotto.utils.NumberOrNot.isNumber;

public class ValueException {
    public static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalStateException("[ERROR] 입력값이 숫자가 아닙니다.");
        }
    }
}
