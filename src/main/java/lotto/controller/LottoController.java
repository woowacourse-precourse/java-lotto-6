package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        inputView = new InputView();
    }

    public void start() {
        inputView.inputAmount();
    }
}
