package lotto.service;

import lotto.model.PurchaseAmount;

public class UserService {
    private PurchaseAmount purchaseAmount;

    public void purchaseLottos(String purchaseAmountInput) {
        purchaseAmount = PurchaseAmount.validate(purchaseAmountInput);
    }
}
