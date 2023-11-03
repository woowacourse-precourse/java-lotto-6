package lotto.controller;

import lotto.domain.LottoPurchasePrice;
import lotto.io.InputManager;
import lotto.io.OutputView;

public class LottoController {

    private final InputManager inputManager;
    private final OutputView outputView;

    public LottoController(InputManager inputManager, OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printLottoPurchasePriceMessage();
        LottoPurchasePrice lottoPurchasePrice = inputManager.inputLottoPurchasePrice();
    }
}
