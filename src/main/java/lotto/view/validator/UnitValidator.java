package lotto.view.validator;

import static lotto.domain.Member.LOTTO_PURCHASED_UNIT;

public class UnitValidator {
    public static void check(int money) {
        if (unitMinCheck(money)) {
            throw new IllegalArgumentException("1000원 이상으로 입력해주세요.");
        }
        if (rangeCheck(money)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
    private static boolean unitMinCheck(long money) {
        return money < 1000;
    }
    private static boolean rangeCheck(int money) {
        return money % LOTTO_PURCHASED_UNIT > 0;
    }
}
