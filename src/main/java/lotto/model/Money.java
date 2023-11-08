package lotto.model;

import java.math.BigDecimal;
import java.util.Objects;
import lotto.utils.CommonValidator;

public class Money {
    private static final String MONEY_REGEX = "^[1-9][0-9]*|0$";

    protected final BigDecimal amount;

    public Money(String amount) {
        validate(amount);
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

    private void validate(String amount) {
        CommonValidator.validateEmptyString(amount);
        if (!amount.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException("잘못된 금액입니다.");
        }
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
