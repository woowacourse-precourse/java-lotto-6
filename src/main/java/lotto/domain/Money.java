package lotto.domain;

import static lotto.constant.ExceptionMessage.LACK_MONEY_EXCEPTION;
import static lotto.constant.ExceptionMessage.WRONG_INPUT_MONEY_EXCEPTION;

public class Money {
    private static final long LOTTO_UNIT_PRICE = 1000L;
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
        return money < LOTTO_UNIT_PRICE;
    }

    private boolean isWrongMoney(long money) {
        return money % LOTTO_UNIT_PRICE != 0;
    }

    public int getPurchaseCount() {
        return (int) (money / LOTTO_UNIT_PRICE);
    }

    public long getMoney() {
        return money;
    }
}
