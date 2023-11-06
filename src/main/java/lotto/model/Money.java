package lotto.model;

import java.util.Objects;
import lotto.util.ErrorCode;

public class Money {
    private static final Integer UNIT = 1000;
    private final Integer money;

    public Money(Integer money) {
        validatePositive(money);
        validateDivisible(money);
        this.money = money;
    }

    private static void validatePositive(Integer money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_NOT_POSITIVE.getMessage());
        }
    }

    private static void validateDivisible(Integer money) {
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
        return Objects.equals(this.money, ((Money) o).money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
