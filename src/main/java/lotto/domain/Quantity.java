package lotto.domain;

import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class Quantity {
    private final int amount;

    private Quantity(final int amount) {
        if (amount < 0 || amount > LottoConfig.MAXIMUM_PURCHASE_LIMIT / LottoConfig.PRICE) {
            throw Errors.INVALID_QUANTITY.getLottoException();
        }
        this.amount = amount;
    }

    public static Quantity of(final Money budget, final int price) {
        return new Quantity((int) budget.getBudget() / price);
    }

    public int getAmount() {
        return amount;
    }
}
