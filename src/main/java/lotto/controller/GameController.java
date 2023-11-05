package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class GameController {
    private PurchaseAmount purchaseAmount;

    public GameController(){
        this.purchaseAmount= new PurchaseAmount(InputView.inputPurchaseAmount());
    }
    public void run(){


    }


}
