package lotto.exception;

public class LottoNumberException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;
    private static final int MIN_AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100000;
    private static final String BLANK = "빈칸은 입력할 수 없습니다.";
    private static final String EMPTY_SPACE = "공백을 포함하지 않는 숫자를 입력해주세요.";
    private static final String NOT_INTEGER = "숫자를 입력해주세요.";
    private static final String OUT_OF_INTEGER_RANGE = "정수 입력 범위를 초과했습니다.";
    private static final String OUT_OF_MAX_AMOUNT = "1,000원 ~ 100,000원 사이의 금액을 입력해주세요.";
    private static final String THOUSAND_UNITS = "구매금액은 1,000원 단위로 입력해주세요.";

    public void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(BLANK);
        }
    }

    public void checkPositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                throw new IllegalArgumentException(NOT_INTEGER);
            }
        }
    }

    public void checkOutOfIntegerRange(String input) {
        if (input.length() >= BILLION_DIGITS
                && input.compareTo("2147483647") > SAME) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE);
        }
    }

    public void checkLessThanMaxAmount(String input) {
        int amount = Integer.parseInt(input);

        if (amount < MIN_AMOUNT
                || amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(OUT_OF_MAX_AMOUNT);
        }
    }

    public void checkEmptySpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(EMPTY_SPACE);
        }
    }

    public void checkThousandUnits (String input) {
        int amount = Integer.parseInt(input);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(THOUSAND_UNITS);
        }
    }
}
