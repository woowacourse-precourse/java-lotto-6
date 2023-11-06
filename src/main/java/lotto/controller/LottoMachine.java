package lotto.controller;

import lotto.view.InputView;

public class LottoMachine {
    private InputView inputView;
    private PurchaseAmount userInput;

    public LottoMachine() {
        inputView = new InputView();
        userInput = new PurchaseAmount();
    }

    private void inputPurchaseAmount () {
        inputView.showLottoAmountInputForm();
        userInput.inputPurchaseAmount();
    }

    public void start(){
        inputPurchaseAmount();
    }
}
