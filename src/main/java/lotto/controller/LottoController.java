package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        getLottoMoney();
    }

    private void getLottoMoney() {
        OutputView.printPurchaseAmount();
        int amount = InputView.readPurchaseAmount();
    }
}
