package lotto.domain;

import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isOverThousand(money);
        canDivideByThousand(money);
    }

    private void isOverThousand(int money) throws IllegalArgumentException {
        if (money < THOUSAND) {
            throw new IllegalArgumentException(UNDER_THOUSAND);
        }
    }

    private void canDivideByThousand(int money) throws IllegalArgumentException {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_THOUSAND);
        }
    }

    public int getLottoCount() {
        return money / THOUSAND;
    }
}
