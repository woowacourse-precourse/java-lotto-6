package lotto.domain.money;

import static lotto.global.constant.exception.ExceptionMessage.*;

public class Money {
    private static final long LOTTO_COST = 1_000;
    private static final long MAX_LIMIT = 1_000_000_000;
    private final long money;

    public Money(long money) {
        this.money = money;
        validateMoney();
    }

    public void validateMoney() {
        validateMoneyIsMoreThanThousand();
        validateMoneyDividedByThousand();
    }

    private void validateMoneyIsMoreThanThousand() {
        if(money < LOTTO_COST) {
            throw new IllegalArgumentException(MONEY_MORE_THAN_THOUSAND.getMessage());
        }
    }

    private void validateMoneyLessThanLongMax() {
        if(money >= MAX_LIMIT) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_TEN_BILLION.getMessage());
        }
    }

    private void validateMoneyDividedByThousand() {
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
