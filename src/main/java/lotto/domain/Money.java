package lotto.domain;

import static lotto.common.ErrorMessages.NOT_IN_1000_UNIT;

import lotto.exception.InputValidationException;

public class Money {
    public static final int COST_PER_LOTTO = 1000;
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % COST_PER_LOTTO != 0) {
            throw new InputValidationException(NOT_IN_1000_UNIT);
        }
    }

    public int getDividedThousandWonCount() {
        return money / COST_PER_LOTTO;
    }

    public int getMoney() {
        return money;
    }
}
