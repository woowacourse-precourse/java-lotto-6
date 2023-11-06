package lotto.model;

import java.math.BigDecimal;
import lotto.utils.AmountValidator;

public class Money {
    private BigDecimal amount;

    public Money(int amount) {
        BigDecimal bigAmount = new BigDecimal(amount);
        AmountValidator.validateAmount(bigAmount);
        this.amount = bigAmount;
    }
    public Money(BigDecimal amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }

    public BigDecimal divideBy(Money divider) {
        return amount.divide(divider.amount);
    }

}
