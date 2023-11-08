package lotto.model;

import static lotto.util.Constants.ERROR;
import static lotto.util.Constants.THOUSAND;
import static lotto.util.validators.PurchaseValidator.validatePurchase;


public class PurchaseAmount {
    private final Integer amount;

    private PurchaseAmount(){
        throw new AssertionError(ERROR + "기본 생성자로 생성할 수 없습니다.");
    }

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
