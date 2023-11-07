package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }
    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        String money = inputView.getLottoPurchaseAmount();
    }
}
