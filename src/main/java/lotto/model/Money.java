package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;
import lotto.utils.AmountValidator;

public class Money {
    private final BigDecimal amount;

    public Money(String amount) {
        AmountValidator.validateMoney(amount);
        this.amount = new BigDecimal(amount);
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money getZeroMoney() {
        return new Money(BigDecimal.ZERO);
    }

    public static Money sum(Money money1, Money money2) {
        BigDecimal sum = money1.amount.add(money2.amount);
        return new Money(sum);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal divideBy(Money divider) {
        return amount.divide(divider.amount);
    }

    public Money multiply(int count) {
        BigDecimal multipliedAmount = this.amount.multiply(new BigDecimal(count));
        return new Money(multipliedAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(getAmount(), money.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount());
    }
}
