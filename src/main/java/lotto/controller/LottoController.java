package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void start() {
        inputView.readInputMoneyMessage();
    }
}
