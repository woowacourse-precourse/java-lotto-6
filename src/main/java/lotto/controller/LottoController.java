package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    private void printPriceMessage() {
        outputView.printPriceMessage();
    }
}
