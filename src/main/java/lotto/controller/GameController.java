package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private PurchaseAmount purchaseAmount;

    public GameController(){
        this.purchaseAmount= new PurchaseAmount(InputView.inputPurchaseAmount());
        OutputView.printNumberOfLottoPurchase(Parser.parseAmountToLottoNumber(purchaseAmount));
    }
    public void run(){


    }


}
