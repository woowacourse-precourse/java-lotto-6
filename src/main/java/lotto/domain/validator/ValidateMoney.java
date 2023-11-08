package lotto.domain.validator;

public class ValidateMoney {
    private final static int MAX_VALUE = 1000000;
    private static final int UNIT = 1000;
    private static final int ZERO = 0;

    public static void isOverThousand(int money) {
        if (money >= UNIT) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 천보다 큰 금액을 입력해주세요.");
    }

    public static void isUnitFollowed(int money) {
        if (money % UNIT == ZERO) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력 해주세요.");
    }

    public static void isMoneyInRange(int money) {
        if (money < MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 100만을 넘는 금액은 입력 할 수 없습니다.");
    }
}
