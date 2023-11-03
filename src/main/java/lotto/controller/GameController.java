package lotto.controller;

import lotto.view.InputView;

public class GameController {
    public static void start(){
        String number = InputPurchaseNumber();
    }

    private static String InputPurchaseNumber(){
        return InputView.purchaseMoney();
    }
}
