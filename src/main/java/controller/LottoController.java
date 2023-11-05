package controller;

import static View.InputView.inputLottoPurchaseAmount;

import domain.Amount;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
    }

}
