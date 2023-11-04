package lotto.model;

import lotto.exception.InvalidMoneyException;

public class Money {

    private static final int LOTTO_PRICE = 1_000;
    private static final int ZERO = 0;
    private final long money;

    public Money(final long money) {
        validateOverThousand(money);
        validateDivideByThousand(money);
        this.money = money;
    }

    private void validateOverThousand(final long money) {
        if (!isOverThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private boolean isOverThousand(final long money) {
        return money >= LOTTO_PRICE;
    }

    private void validateDivideByThousand(final long money) {
        if (!canDivideByThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private boolean canDivideByThousand(final long money) {
        return money % LOTTO_PRICE == ZERO;
    }

    public long getMoney() {
        return money;
    }
}
