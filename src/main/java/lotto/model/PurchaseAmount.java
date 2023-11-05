package lotto.model;

import static lotto.util.validators.PurchaseValidator.validatePurchase;


public class PurchaseAmount {
    private static final Integer THOUSAND = 1000;
    private final Integer amount;

    public PurchaseAmount(String amount) {
        validatePurchase(amount);
        this.amount = Integer.valueOf(amount);
    }

    public Integer exchangeAmount() {
        return this.amount / THOUSAND;
    }
}
