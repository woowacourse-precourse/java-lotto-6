package lotto.domain;

import static lotto.domain.DomainError.*;

public class PurchaseAmounts {
    private final int LOTTO_PRICE = 1000;

    private int price;

    public PurchaseAmounts(int price) {
        validatePurchaseAmounts(price);
        this.price = price;
    }

    private void validatePurchaseAmounts(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_ERROR.getMessage());
        }
    }
}
