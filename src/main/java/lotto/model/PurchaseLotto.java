package lotto.model;

import static lotto.util.Constant.*;

import lotto.util.validator.PurchaseAmountValidator;

public class PurchaseLotto {

    private int purchaseAmount;
    private int numberOfPurchases;

    public void purchase(String input) {
        int amount = PurchaseAmountValidator.createValidator().validate(input);
        this.purchaseAmount = amount;
        this.numberOfPurchases = amount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }
}
