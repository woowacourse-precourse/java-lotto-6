package lotto.controller;

import lotto.model.Money;
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
        int money = inputView.getLottoPurchaseAmount();

    }
}
