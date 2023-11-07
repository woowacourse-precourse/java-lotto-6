package lotto.domain.money;

import java.util.Objects;
import lotto.domain.validator.MoneyValidator;

public class Money {
    public static final int LOTTO_PRICE = 1_000;
    private final int money;

    private Money(int money) {
        MoneyValidator.verifyPositiveMoney(money);
        this.money = money;
    }

    public static Money fromInitialMoney(int money) {
        MoneyValidator.verifyMinAmount(money);
        MoneyValidator.verifyMaxAmount(money);
        MoneyValidator.verifyDivisibleBy(money);
        return new Money(money);
    }

    public static Money fromRemainingMoney(int money) {
        MoneyValidator.verifyMaxAmount(money);
        MoneyValidator.verifyDivisibleBy(money);
        return new Money(money);
    }

    public Money decremented() {
        return Money.fromRemainingMoney(money - LOTTO_PRICE);
    }

    public boolean isNotEnough() {
        return money < LOTTO_PRICE;
    }

    public boolean isEnough() {
        return money >= LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money money1)) {
            return false;
        }
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
