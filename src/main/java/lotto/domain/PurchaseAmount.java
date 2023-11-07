package lotto.domain;

import lotto.util.Validator;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(int money) {
        Validator.validatePurchaseAmount(money);
        this.money = money;
    }


}
