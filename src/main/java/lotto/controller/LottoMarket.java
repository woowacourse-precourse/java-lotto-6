package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMarket {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void enter() {
        outputView.printInputMoneyMessage();
        String money = inputView.readMoneyToBuyLotto();
    }
}
