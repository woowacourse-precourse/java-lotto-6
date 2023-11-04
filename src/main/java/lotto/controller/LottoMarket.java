package lotto.controller;

import lotto.view.OutputView;

public class LottoMarket {
    private final OutputView outputView = new OutputView();

    public void enter() {
        outputView.printInputMoneyMessage();
    }
}
