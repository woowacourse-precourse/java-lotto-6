package lotto.service;

import lotto.domain.PurchaseAmount;

public class LottoService {
    public void generateLotteries(String inputAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
    }
}
