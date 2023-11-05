package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;

public class GameController {

    public void start() {
        Purchase purchase = createPurchase(InputView.getPurchaseMoney());
    }

    private Purchase createPurchase(int purchaseMoney) {
        try {
            return new Purchase(purchaseMoney);
        } catch (IllegalArgumentException e) {
            InputView.printErrorMessage(e);
            return new Purchase(getPurchaseMoney());
        }
    }

    private int getPurchaseMoney() {
        return InputView.getPurchaseMoney();
    }
}