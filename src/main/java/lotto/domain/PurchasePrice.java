package lotto.domain;

import lotto.utils.ValidationException;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = parsingStringToInt(purchasePrice);
    }

    public int getPurchaseCount() {
        return purchasePrice / 1000;
    }

    private void validate(String price) {
        ValidationException validation = new ValidationException();

        validation.isNullOrEmpty(price);
        validation.isInteger(price);

        int parsingPrice = parsingStringToInt(price);

        validation.isDivideByPriceUnit(parsingPrice);
    }

    private int parsingStringToInt(String purchasePrice) {
        return Integer.parseInt(purchasePrice);
    }
}
