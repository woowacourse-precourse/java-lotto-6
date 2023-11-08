package lotto.domain;

import static lotto.domain.exception.DomainExceptionCode.MONEY_GRATER_THAN_ZERO;

public record Money(long value) {

    private static final int FACTOR = 100; //배율

    public Money {
        MONEY_GRATER_THAN_ZERO.dynamicInvokeBy(() -> value < 0);
    }

    public double calculateProfitMargin(Money profit) {
        return (double) profit.value / value * FACTOR;
    }

}
