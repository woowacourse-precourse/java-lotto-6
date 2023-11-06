package lotto.model;

import java.util.Objects;
import lotto.util.ErrorCode;

public class Money {
    private static final int UNIT = 1000;
    private final int money;

    public Money(int money) {
        validatePositive(money);
        validateDivisible(money);
        this.money = money;
    }

    private static void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_NOT_POSITIVE.getMessage());
        }
    }

    private static void validateDivisible(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_NOT_DIVISIBLE.getMessage());
        }
    }

    public Integer numberOfPurchaseAvailable() {
        return money / UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return this.money == ((Money) o).money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
