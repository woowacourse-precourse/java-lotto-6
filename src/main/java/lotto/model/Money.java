package lotto.model;

import lotto.exceptionMessages.ExceptionMessages;

public class Money {
    private static final int THOUSAND = 1_000;
    private static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validateZeroMoney(money);
        validateDivideMoney(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / THOUSAND;
    }

    private void validateZeroMoney(int money) {
        if (money == ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_MONEY_ZERO.getMessage());
        }
    }

    private void validateDivideMoney(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_MONEY_DIVIDE.getMessage());
        }
    }
}
