package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startLotto() {
        outputView.printGetPurchasePriceMessage();
        inputView.inputPurchasePrice();
    }
}
