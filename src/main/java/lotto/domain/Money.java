package lotto.domain;

import java.text.DecimalFormat;

public class Money {
    public static final Money ZERO = new Money(0);

    public Integer getAmount() {
        return amount;
    }

    private final Integer amount;

    public Money(Integer amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public Money minus(Money amount) {
        return new Money(this.amount - amount.amount);
    }

    public Money multiply(Money amount) {
        return new Money(this.amount * amount.amount);
    }


    public boolean hasNotMoney() {
        return amount <= 0;
    }

    public double calculateRateOfReturn(Money finalAmount) {
        return ((finalAmount.amount - amount) / (double)amount) * 100;
    }
}
