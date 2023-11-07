package lotto.domain;

import static lotto.constant.ExceptionMessage.LACK_MONEY_EXCEPTION;
import static lotto.constant.ExceptionMessage.WRONG_INPUT_MONEY_EXCEPTION;

public class Money {
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (isLackMoney(money)) {
            throw new IllegalArgumentException(LACK_MONEY_EXCEPTION.getMessage());
        }

        if (isWrongMoney(money)) {
            throw new IllegalArgumentException(WRONG_INPUT_MONEY_EXCEPTION.getMessage());
        }
    }

    private boolean isLackMoney(long money) {
        return money < 1000;
    }

    private boolean isWrongMoney(long money) {
        return money % 1000 != 0;
    }

    public int getPurchaseCount() {
        return (int) money / 1000;
    }

    public long getMoney() {
        return money;
    }
}
