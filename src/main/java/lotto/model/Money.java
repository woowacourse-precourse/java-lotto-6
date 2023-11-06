package lotto.model;

import java.math.BigDecimal;
import lotto.utils.AmountValidator;

public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }
}
