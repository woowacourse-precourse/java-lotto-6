package lotto.controller;

import lotto.domain.PurchaseAmount;
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
        PurchaseAmount purchaseAmount = setPurchaseAmount();
    }

    public PurchaseAmount setPurchaseAmount() {
        outputView.printInputPurchaseAmount();
        String amount = inputView.inputPurchaseAmount();
        return new PurchaseAmount(amount);
    }
}
