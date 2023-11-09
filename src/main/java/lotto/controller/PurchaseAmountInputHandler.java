package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseAmountInputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    private PurchaseAmountInputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static PurchaseAmountInputHandler create(InputView inputView, OutputView outputView) {
        return new PurchaseAmountInputHandler(inputView, outputView);
    }

    public LottoPurchaseAmount createPurchaseAmount() {
        outputView.printAskPurchaseAmount();
        while (true) {
            try {
                String purchaseAmountInput = inputView.readInputFromUser();
                return LottoPurchaseAmount.create(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
