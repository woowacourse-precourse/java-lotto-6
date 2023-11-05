package lotto.util.wrapper;

import static lotto.util.validators.PurchaseValidator.validatePurchase;


public class PurchaseAmount {
    private static final Integer THOUSAND = 1000;
    private final Integer value;

    public PurchaseAmount(String value) {
        validatePurchase(value);
        this.value = Integer.valueOf(value);
    }

    public Integer exchangeAmount() {
        return this.value / THOUSAND;
    }
}
