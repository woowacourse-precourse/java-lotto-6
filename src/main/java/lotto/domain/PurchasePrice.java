package lotto.domain;

import lotto.utils.ValidationException;

public class PurchasePrice {
    private int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        isPurchasePriceValid(purchasePrice);
        this.purchasePrice = parsingStringToInt(purchasePrice);
    }

    private void isPurchasePriceValid(String purchasePrice) {
        ValidationException validation = new ValidationException();

        validation.isNullOrEmpty(purchasePrice);
        validation.isInteger(purchasePrice);

        int parsingPurchasePrice = parsingStringToInt(purchasePrice);
        validation.isDivideByPriceUnit(parsingPurchasePrice);
    }

    private int parsingStringToInt(String purchasePrice) {
        return Integer.parseInt(purchasePrice);
    }
}
