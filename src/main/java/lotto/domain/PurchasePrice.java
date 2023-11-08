package lotto.domain;

import lotto.vailator.PurchasePriceValidator;

import static lotto.util.LottoNumber.PURCHASE_MIN_PRICE;

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

    public int getLottoAmount() {
        return price / PURCHASE_MIN_PRICE.getValue();
    }
}
