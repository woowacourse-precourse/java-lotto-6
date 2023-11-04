package lotto.model;

import static lotto.util.Constant.LOTTO_PRICE;
import static lotto.util.Constant.ZERO;

import lotto.exception.InvalidMoneyException;

public class Money {

    private final int money;

    public Money(final int money) {
        validateOverThousand(money);
        validateDivideByThousand(money);
        this.money = money;
    }

    private void validateOverThousand(final int money) {
        if (!isOverThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private boolean isOverThousand(final int money) {
        return money >= LOTTO_PRICE.getValue();
    }

    private void validateDivideByThousand(final int money) {
        if (!canDivideByThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private boolean canDivideByThousand(final int money) {
        return money % LOTTO_PRICE.getValue() == ZERO.getValue();
    }

    public int getMoney() {
        return money;
    }
}
