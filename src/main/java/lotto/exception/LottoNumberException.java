package lotto.exception;

public class LottoNumberException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;
    private static final String NOT_INTEGER = "숫자를 입력해주세요.";
    private static final String OUT_OF_INTEGER_RANGE = "정수 입력 범위를 초과했습니다.";

    public void validatePositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                throw new IllegalArgumentException(NOT_INTEGER);
            }
        }
    }

    public boolean isOutOfIntegerRange(String number) {
        if (number.length() > BILLION_DIGITS
                || number.compareTo("2147483647") > SAME) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE);
        }

        return false;
    }
}
