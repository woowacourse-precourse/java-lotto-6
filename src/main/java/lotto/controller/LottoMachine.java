package lotto.controller;

import lotto.view.InputView;

public class LottoMachine {
    private InputView inputView;
    private LottoPurchase lottoPurchase;

    public LottoMachine() {
        inputView = new InputView();
        lottoPurchase = new LottoPurchase();
    }

    private void inputPurchaseAmount () {
        inputView.showAmountInputForm();
        lottoPurchase.inputAmount();
    }

    public void start(){
        inputPurchaseAmount();
    }
}
