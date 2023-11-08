package lotto.domain.validator;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class ValidateMoney {
    private final static int MAX_VALUE = 1000000;

    public static ThrowingCallable isOverThousand(int money) {
        if (money >= 1000) {
            return null;
        }
        throw new IllegalArgumentException("[ERROR] 천보다 큰 금액을 입력해주세요.");
    }

    public static ThrowingCallable isUnitFollowed(int money) {
        if (money % 1000 == 0) {
            return null;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력 해주세요.");
    }

    public static ThrowingCallable isMoneyInRange(int money) {
        if (money < MAX_VALUE) {
            return null;
        }
        throw new IllegalArgumentException("[ERROR] 100만을 넘는 금액은 입력 할 수 없습니다.");
    }
}
