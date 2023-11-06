package lotto.exception;


import static lotto.utils.NumberOrNot.isNumber;

public class ValueException {
    public static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
    }
}


