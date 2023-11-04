package lotto.controller;

import lotto.domain.LottoPurchaseManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeLottoPurchaseManager();
        String purchaseAmount = inputView.printAskPurchaseAmount();
        lottoPurchaseManager.calculateLottoQuantity(purchaseAmount);
    }

    private void initializeLottoPurchaseManager() {
        lottoPurchaseManager = new LottoPurchaseManager();
    }
}
