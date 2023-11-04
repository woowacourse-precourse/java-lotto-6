package lotto.controller;

import lotto.view.InputView;

public class Controller {
    private final InputView inputView;

    public Controller() {
        this.inputView = new InputView();
    }

    public int getPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

}
