package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
    }

    private PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
