package lotto.domain;

import static lotto.domain.DomainError.*;

public class PurchaseAmounts {
    private final int LOTTO_PRICE = 1000;

    private int price;
    private int count;

    public PurchaseAmounts(int price) {
        validatePurchaseAmounts(price);
        this.price = price;
        this.count = price / LOTTO_PRICE;
    }

    private void validatePurchaseAmounts(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_ERROR.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
