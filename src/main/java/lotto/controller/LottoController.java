package lotto.controller;

import lotto.view.View;

public class LottoController {
    View view = new View();

    public void run() {
        view.printPurchaseAmountInputMessage();
        view.inputValue();
    }
}
