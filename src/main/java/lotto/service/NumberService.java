package lotto.service;

import lotto.domain.PurchaseAmount;

public class NumberService {
    public static final int LOTTO_PRICE = 1000;
    private PurchaseAmount purchaseAmount;

    public void initPurchaseAmount(String input) {
        this.purchaseAmount = new PurchaseAmount(input);
    }
}
