package controller;

import static view.InputView.inputLottoPurchaseAmount;


import domain.Amount;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
        amount.outputLottoPurchaseAmount();
    }

}
