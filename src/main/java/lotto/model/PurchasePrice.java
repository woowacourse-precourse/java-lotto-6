package lotto.model;

import lotto.validator.PurchasePriceValidator;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validatepurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatepurchasePrice(int purchasePrice) {
        PurchasePriceValidator.validatePriceRange(purchasePrice);
        PurchasePriceValidator.validatePriceDivision(purchasePrice);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getLottoQuantity() {
        return purchasePrice / PurchasePriceValidator.LOTTO_PRICE;
    }
}
