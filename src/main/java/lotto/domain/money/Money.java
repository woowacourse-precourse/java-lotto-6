package lotto.domain.money;

import static lotto.global.constant.exception.ExceptionMessage.*;

public class Money {
    private static final long LOTTO_COST = 1_000;
    private static final long MAX_LIMIT = 1_000_000_000;
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(int money) {
        validateMoneyIsMoreThanThousand(money);
        validateMoneyIsMoreThanThousand(money);
        validateMoneyDividedByThousand(money);
    }

    private void validateMoneyIsMoreThanThousand(int money) {
        if(money < LOTTO_COST) {
            throw new IllegalArgumentException(MONEY_MORE_THAN_THOUSAND.getMessage());
        }
    }

    private void validateMoneyLessThanLongMax(int money) {
        if(money >= MAX_LIMIT) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_TEN_BILLION.getMessage());
        }
    }

    private void validateMoneyDividedByThousand(int money) {
        if(money % LOTTO_COST != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDED_INTO_THOUSAND.getMessage());
        }
    }

    public long getNumberOfTheLotto() {
        return money / LOTTO_COST;
    }

    public long getMoney() {
        return money;
    }
}
