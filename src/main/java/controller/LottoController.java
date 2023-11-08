package controller;

import view.InputPrice;

public class LottoController {
    public void run() {
        try {
            InputPrice.enterPurchaseAmount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}

