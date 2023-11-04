package lotto.service;

import lotto.util.Validation;

public class LottoService {
    public void generateLotteries(String input) {
        int purchaseAmount = getPurchaseAmount(input);
    }

    private int getPurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        Validation.purchaseAmount(purchaseAmount);
        return purchaseAmount % 1000;
    }
}
