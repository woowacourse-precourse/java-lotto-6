package lotto.exception;

public class LottoNumberException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;
    private static final int MIN_AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100000;
    private static final String NOT_INTEGER = "숫자를 입력해주세요.";
    private static final String OUT_OF_INTEGER_RANGE = "정수 입력 범위를 초과했습니다.";
    private static final String OUT_OF_MAX_AMOUNT = "1,000원 ~ 100,000원 사이의 금액을 입력해주세요.";
    private static final String EMPTY_SPACE = "공백을 포함하지 않는 숫자를 입력해주세요.";

    public void checkPositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                throw new IllegalArgumentException(NOT_INTEGER);
            }
        }
    }

    public void checkOutOfIntegerRange(String amount) {
        if (amount.length() > BILLION_DIGITS
                || amount.compareTo("2147483647") > SAME) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE);
        }
    }

    public void checkLessThanMaxAmount(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT
                || Integer.parseInt(amount) > MAX_AMOUNT) {
            throw new IllegalArgumentException(OUT_OF_MAX_AMOUNT);
        }
    }

    public void checkEmptySpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(EMPTY_SPACE);
        }
    }
}
