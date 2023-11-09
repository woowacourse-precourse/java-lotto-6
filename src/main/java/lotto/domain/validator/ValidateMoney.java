package lotto.domain.validator;

public class ValidateMoney {
    private final static int MAX_VALUE = 1000000;
    private static final int UNIT = 1000;
    private static final int ZERO = 0;
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String MONEY_ERROR_LACK = "1000보다 큰 금액을 입력해주세요.";
    private static final String  ERROR_UNIT_FOLLOW = "금액은 천원 단위로 입력 해주세요.";
    private static final String ERROR_MONEY_ERROR_OVER = "100만을 넘는 금액은 입력 할 수 없습니다.";

    public static void isOverThousand(int money) {
        if (money >= UNIT) {
            return;
        }
        throw new IllegalArgumentException(ERROR_HEAD + MONEY_ERROR_LACK);
    }

    public static void isUnitFollowed(int money) {
        if (money % UNIT == ZERO) {
            return;
        }
        throw new IllegalArgumentException(ERROR_HEAD + ERROR_UNIT_FOLLOW);
    }

    public static void isMoneyInRange(int money) {
        if (money < MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException(ERROR_HEAD + ERROR_MONEY_ERROR_OVER);
    }
}
