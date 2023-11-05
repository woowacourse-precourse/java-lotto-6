package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    public void run() {
        getLottoMoney();
    }

    private void getLottoMoney() {
        OutputView.printPurchaseAmount();
        int amount = inputView.readPurchaseAmount();
    }
}
