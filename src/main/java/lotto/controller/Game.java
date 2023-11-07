package lotto.controller;

import lotto.view.InputView;

public class Game {

    private InputView inputView;

    public Game() {
        this.inputView = new InputView();
        init();
    }

    private void init() {
        inputView.inputPurchasePrice();
        inputView.inputWinningNumber();
        inputView.inputBonusNumber();
    }
}
