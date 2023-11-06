package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        setPurchaseAmount();
    }

    public void setPurchaseAmount() {
        outputView.printInputPurchaseAmount();
        System.out.println(inputView.inputPurchaseAmount());
    }
}
