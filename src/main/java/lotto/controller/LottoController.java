package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        getLottoMoney();
    }

    public void getLottoMoney() {
        OutputView.printPurchaseAmount();
        InputView.readPurchaseAmount();
    }
}
