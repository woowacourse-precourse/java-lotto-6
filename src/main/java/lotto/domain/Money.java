package lotto.domain;

import lotto.utils.GameRules;

public class Money {
    private static final String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.";

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validateMoneyUnit(money);
        return new Money(money);
    }

    private static void validateMoneyUnit(int money) {
        if (money % GameRules.MINIMUN_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }
}
