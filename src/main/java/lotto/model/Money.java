package lotto.model;

import static lotto.constant.CommonUnits.MONEY_UNIT;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int won) {
        if (won % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] "+ MONEY_UNIT + "원 단위로 입력해주세요.");
        }
    }
}
