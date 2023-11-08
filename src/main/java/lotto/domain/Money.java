package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int UNIT = 1000;
    private static final String UNIT_EXCEPTION = "%d원 단위만 가능합니다.";

    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (isWrongUnit(amount)) {
            throw new IllegalArgumentException(String.format(UNIT_EXCEPTION, UNIT));
        }
    }

    private boolean isWrongUnit(int amount) {
        return amount <= 0 || amount % UNIT != 0;
    }

    public int calculateQuantity(int price) {
        return amount / price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int getAmount() {
        return amount;
    }
}
