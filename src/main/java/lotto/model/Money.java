package lotto.model;

import static lotto.util.Constant.LOTTO_PRICE;
import static lotto.util.Constant.ZERO;

import lotto.exception.InvalidMoneyException;

public class Money {

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
        return money >= LOTTO_PRICE.getValue();
    }

    private void validateDivideByThousand(final long money) {
        if (!canDivideByThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private boolean canDivideByThousand(final long money) {
        return money % LOTTO_PRICE.getValue() == ZERO.getValue();
    }

    public long getMoney() {
        return money;
    }
}
