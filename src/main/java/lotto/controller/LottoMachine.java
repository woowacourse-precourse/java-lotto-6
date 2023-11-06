package lotto.controller;

import lotto.view.InputView;

public class LottoMachine {
    private InputView inputView;
    private UserInput userInput;

    public LottoMachine() {
        inputView = new InputView();
        userInput = new UserInput();
    }

    private void inputPurchaseAmount () {
        inputView.showLottoAmountInputForm();
        userInput.inputPurchaseAmount();
    }

    public void start(){
        inputPurchaseAmount();
    }
}
