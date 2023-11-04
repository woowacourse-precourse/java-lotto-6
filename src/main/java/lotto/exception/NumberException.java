package lotto.exception;



public class NumberException {
    public static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
    }
}


