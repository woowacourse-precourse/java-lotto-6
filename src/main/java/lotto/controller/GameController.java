package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class GameController {

    InputView inputView = new InputView();
    public void init() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
    }

    public PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
