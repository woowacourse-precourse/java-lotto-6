package lotto.domain;

import lotto.domain.validator.ValidateMoney;

public class Money {
    private static final int UNIT = 1000;
    private final Integer money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        ValidateMoney.isOverThousand(money);
        ValidateMoney.isUnitFollowed(money);
        ValidateMoney.isMoneyInRange(money);
    }

    public int availableCount() {
        return money / UNIT;
    }
}
