package lotto.exception;


import static lotto.controller.NumberOrNot.isNumber;

public class NumberException {
    public static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
    }
}


