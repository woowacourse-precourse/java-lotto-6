package lotto.domain;

import static lotto.service.Validator.validateDividedBy1000Won;
import static lotto.service.Validator.validateLess1000Won;
import static lotto.service.Validator.validateNumber;

public class PurchaseAmount {
    private final String purchaseAmount;

    public PurchaseAmount(String purchaseAmount){
        validateNumber(purchaseAmount);
        validateLess1000Won(purchaseAmount);
        validateDividedBy1000Won(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseAmount() {
        return Integer.parseInt(purchaseAmount);
    }
}
