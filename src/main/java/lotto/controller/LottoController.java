package lotto.controller;

import lotto.domain.LottoCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        LottoCounter counter = readPurchaseAmount();
    }

    private LottoCounter readPurchaseAmount() {
        outputView.printPurchaseMessage();
        LottoCounter counter = inputView.readPurchaseAmount();
        outputView.printNewLine();
        return counter;
    }
}
