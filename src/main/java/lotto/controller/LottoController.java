package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run(){
        int purchasePrice = getPurchasePrice();

    }

    private int getPurchasePrice(){
        OutputView.printInputPrice();
        return InputView.getPurchaseLottoPrice();
    }

}
