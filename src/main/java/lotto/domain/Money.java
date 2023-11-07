package lotto.domain;

import lotto.exception.ArgumentIsZeroException;
import lotto.exception.IndivisibleByUnitException;

public class Money {
    private static final int UNIT = 1000;
    private static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getNumberOfLottos() {
        return money / UNIT;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        validateNotZero(money);
        validateDivisibleByUnit(money);
    }

    private void validateDivisibleByUnit(int money) {
        if (money % UNIT != 0) {
            throw new IndivisibleByUnitException();
        }
    }

    private void validateNotZero(int money) {
        if (money == ZERO) {
            throw new ArgumentIsZeroException();
        }
    }
}
