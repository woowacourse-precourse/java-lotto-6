package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    private static int amount;

    private int getPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputAmount());
        amount = Integer.parseInt(purchaseAmount.getAmount());
        return amount / 1000;
    }
}
