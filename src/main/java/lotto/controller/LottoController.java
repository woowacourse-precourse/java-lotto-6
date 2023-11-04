package lotto.controller;

import lotto.io.InputManager;
import lotto.io.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputManager inputManager;

    public LottoController(final OutputView outputView, final InputManager inputManager) {
        this.outputView = outputView;
        this.inputManager = inputManager;
    }

    public void run() {
        outputView.printPurchaseAmountRequset();
        inputManager.readPurchaseAmount();
    }
}
