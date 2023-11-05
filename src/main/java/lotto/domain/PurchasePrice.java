package lotto.domain;

import lotto.validator.PurchasePriceValidator;

public class PurchasePrice {
    private int price;

    public PurchasePrice(int price) {
        validatePurchasePrice(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validatePurchasePrice(int price) {
        PurchasePriceValidator purchasePriceValidator = new PurchasePriceValidator();

        purchasePriceValidator.checkRemainderZero(price);
        purchasePriceValidator.checkOverMinPrice(price);
    }
}
