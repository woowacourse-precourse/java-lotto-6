package controller;

import view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController() {
        inputView = new InputView();
    }

    public void start() {
        RequestLottoAmount();
    }

    private void RequestLottoAmount() {
        inputView.printRequestAmount();
        inputView.InputAmount();
    }
}
