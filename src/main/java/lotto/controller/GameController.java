package lotto.controller;

import lotto.model.LottoCount;
import lotto.model.PurchaseMoney;
import lotto.view.InputView;

public class GameController {
    public static void start(){

        PurchaseMoney purchaseMoney = new PurchaseMoney(InputPurchaseNumber());
        LottoCount lottoCount = new LottoCount(purchaseMoney.getValue());
    }

    private static String InputPurchaseNumber(){
        return InputView.purchaseMoney();
    }
}
