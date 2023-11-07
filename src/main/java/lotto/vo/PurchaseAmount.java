package lotto.vo;

import java.util.Objects;

public class PurchaseAmount {

    private static final int PRICE_UNIT = 1_000;

    private final int amount;

    public PurchaseAmount(final int price) {
        this.amount = price / PRICE_UNIT;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseAmount that = (PurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
