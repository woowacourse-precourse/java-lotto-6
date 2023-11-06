package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.validator.PurchasePriceValidator;

public class PurchasePrice {

    private final int price;

    private PurchasePrice(int value) {
        PurchasePriceValidator.indivisibleUnit(value);
        price = value;
    }

    public static PurchasePrice from(int value) {
        return new PurchasePrice(value);
    }

    public int calculatePurchaseCount() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }

}
