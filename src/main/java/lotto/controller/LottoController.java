package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        PurchaseAmount purchaseAmount = askPurchaseAmount();
    }

    private PurchaseAmount askPurchaseAmount() {
        return PurchaseAmount.from(inputView.askPurchaseAmount());
    }
}
