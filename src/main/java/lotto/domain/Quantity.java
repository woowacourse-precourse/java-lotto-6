package lotto.domain;

import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class Quantity {
    private final int quantity;

    private Quantity(final int quantity) {
        if (quantity < 0 || quantity > LottoConfig.MAXIMUM_PURCHASE_LIMIT / LottoConfig.PRICE) {
            throw Errors.INVALID_QUANTITY.getLottoException();
        }
        this.quantity = quantity;
    }

    public static Quantity of(final Money budget, final int price) {
        return new Quantity((int) budget.getValue() / price);
    }

    public int getQuantity() {
        return quantity;
    }
}
