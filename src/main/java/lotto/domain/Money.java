package lotto.domain;

import java.text.DecimalFormat;

public class Money implements Comparable<Money> {
    public static final Money ZERO = new Money(0);
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

    public boolean hasNotMoney(Money amount) {
        return this.amount < amount.amount;
    }

    public double calculateRateOfReturn(Money finalAmount) {
        return ((finalAmount.amount - amount) / (double)amount) * 100;
    }

    public String formatWithCommas() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }

    @Override
    public int compareTo(Money money) {
        return amount - money.amount;
    }
}
