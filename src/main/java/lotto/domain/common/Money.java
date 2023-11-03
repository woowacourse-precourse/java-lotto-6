package lotto.domain.common;

import java.util.Objects;

public class Money {

    private static final int NON_POSITIVE_STANDARD = 0;
    private static final String NON_POSITIVE_MONEY_MESSAGE = "돈은 양수여야 합니다.";

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        checkPositiveMoney(money);

        return new Money(money);
    }

    private static void checkPositiveMoney(int money) {
        if (money <= NON_POSITIVE_STANDARD) {
            throw new IllegalArgumentException(NON_POSITIVE_MONEY_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
