package lotto.constant;

import java.math.BigDecimal;

public enum AmountConstraint {
    MAXIMUM_PURCHASE_AMOUNT(BigDecimal.valueOf(100000L)),
    THOUSAND(BigDecimal.valueOf(1000));

    private final BigDecimal amount;

    AmountConstraint(BigDecimal number) {
        this.amount = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isUnder(BigDecimal amount) {
        return this.getAmount().compareTo(amount) < 0;
    }

    public boolean isNotDivisorOf(BigDecimal amount) {
        return !amount.remainder(this.getAmount()).equals(BigDecimal.ZERO);
    }
}
