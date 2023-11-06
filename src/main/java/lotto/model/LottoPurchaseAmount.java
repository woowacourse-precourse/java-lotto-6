package lotto.model;

import java.math.BigDecimal;

public class LottoPurchaseAmount {
    private final BigDecimal amount;

    private LottoPurchaseAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static LottoPurchaseAmount from(String input) {
        long temporaryValue = Long.parseLong(input);
        return new LottoPurchaseAmount(BigDecimal.valueOf(temporaryValue));
    }
}
