package lotto.controller;

import lotto.model.PurchaseMoney;
import lotto.view.InputView;

public class GameController {
    public static void start(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputPurchaseNumber());
    }

    private static String InputPurchaseNumber(){
        return InputView.purchaseMoney();
    }
}
