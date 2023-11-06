package lotto.model;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

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
        return purchasePrice / LOTTO_PRICE.getValue();
    }
}
