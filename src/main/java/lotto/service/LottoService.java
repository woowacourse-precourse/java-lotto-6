package lotto.service;

import lotto.domain.PurchaseMoney;

public class LottoService {
    public void purchase(Integer purchaseAmount) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount);
    }
}
