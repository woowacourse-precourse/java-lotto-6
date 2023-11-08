package lotto.domain.money;

import static lotto.domain.constant.DomainConstant.HUNDRED;
import static lotto.domain.constant.DomainConstant.ZERO;

public record Money(Long amount) {
    public static final Money ZERO_MONEY = new Money(0L);

    public Money sum(final Money money) {
        return new Money(amount + money.amount());
    }

    public Money multiplyByCount(final Long count) {
        return new Money(amount * count);
    }

    public boolean isLessThan(final Money other) {
        return amount < other.amount();
    }

    public boolean cantDividedBy(final Money other) {
        return amount % other.amount() != ZERO;
    }

    public double getPercentageOf(final Money other) {
        return ((double) amount / other.amount()) * HUNDRED;
    }
}
