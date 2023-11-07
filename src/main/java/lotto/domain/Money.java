package lotto.domain;

import static lotto.ErrorMessage.MONEY_NEGATIVE_ERROR;

import java.util.Objects;

public final class Money implements Comparable<Money> {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR.getMessage());
        }
    }

    public boolean isMultipleOf(int unitPrice) {
        return amount % unitPrice == 0 && amount >= unitPrice;
    }

    public int getCountForPrice(int price) {
        return amount / price;
    }

    public Money multiply(int multiplier) {
        return new Money(amount * multiplier);
    }

    public Money add(Money addendMoney) {
        return new Money(amount + addendMoney.amount);
    }

    public double getRatio(Money divisorMoney) {
        return (double) amount / divisorMoney.amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Money otherMoney)) {
            return false;
        }
        return this.amount == otherMoney.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public int compareTo(Money otherMoney) {
        return Integer.compare(this.amount, otherMoney.amount);
    }

    public int getAmount() {
        return amount;
    }
}
