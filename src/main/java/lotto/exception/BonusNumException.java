package lotto.exception;

public class BonusNumException {

    private static final String INT_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 숫자를 입력해야 합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자를 입력해야 합니다.";

    private static final String DUP_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호에 있는 숫자와 다른 숫자를 입력해야 합니다.";

    public static void BonusIntException() {
        throw new IllegalArgumentException(INT_EXCEPTION_MESSAGE);
    }

    public static void BonusRangeException() {
        throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
    }

    public static void BonusDupException() {
        throw new IllegalArgumentException(DUP_EXCEPTION_MESSAGE);
    }

}
