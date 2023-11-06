package lotto.domain.money;

import java.text.DecimalFormat;
import lotto.domain.constant.DomainConstant;

public record Money(long amount) {
    public static final Money ZERO = new Money(0);
    private static final String WON = "원";
    private static final String DECIMAL_FORMAT = "###,###";

    public Money add(long money) {
        return new Money(amount + money);
    }

    public Money sum(Money money) {
        return new Money(amount + money.amount());
    }

    public Money multiplyByCount(long count) {
        return new Money(amount * count);
    }

    public boolean isLessThan(Money other) {
        return amount < other.amount();
    }

    public boolean cantDividedBy(Money other) {
        return amount % other.amount() != DomainConstant.ZERO;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        return formatter.format(amount) + WON;
    }
}
