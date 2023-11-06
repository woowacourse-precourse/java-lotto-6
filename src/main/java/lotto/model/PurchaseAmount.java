package lotto.model;

import static lotto.util.Constants.THOUSAND;
import static lotto.util.validators.PurchaseValidator.validatePurchase;


public class PurchaseAmount {
    private final Integer amount;

    public PurchaseAmount(String amount) {
        validatePurchase(amount);
        this.amount = Integer.valueOf(amount);
    }

    public Integer exchangeAmount() {
        return this.amount / THOUSAND;
    }

    public Integer exchangePurchase() {
        return exchangeAmount() * THOUSAND;
    }
}
