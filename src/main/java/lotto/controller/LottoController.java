package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.model.User;
import lotto.view.InputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        User user = User.purchaseLottos(purchaseAmount);
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
