package lotto.domain;

import static lotto.domain.exception.DomainExceptionCode.MONEY_GRATER_THAN_ZERO;

public record Money(long value) {

    public Money {
        MONEY_GRATER_THAN_ZERO.dynamicInvokeBy(() -> value < 0);
    }

    public double calculateProfitMargin(Money profit) {
        var temp = profit.value * 1.0 / value * 100;
        return (double) Math.round(temp * 100) / 100;
    }
}
