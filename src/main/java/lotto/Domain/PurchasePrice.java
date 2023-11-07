package lotto.Domain;

import lotto.Validator.Validator;

public class PurchasePrice {
    private static final int LOTTO_PRICE = 1000;
    private final int purchasrPrice;
    public PurchasePrice(int purchasrPrice) {
        Validator.validateDivisibleBy1000(purchasrPrice);
        this.purchasrPrice = purchasrPrice;
    }

    public int findLottoQuantity() {
        return calculateLottoQuantity(this.purchasrPrice);
    }

    private int calculateLottoQuantity(int purchasrPrice) {
        return purchasrPrice / LOTTO_PRICE;
    }
}
