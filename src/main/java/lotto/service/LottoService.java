package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.util.Validation;

public class LottoService {
    public void generateLotteries(String inputAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
    }
}
