package lotto.controller;

import lotto.ValidationUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        String purchaseAmount;
        do {
            outputView.printPurchaseAmountMessage();
            purchaseAmount = inputView.scanPurchaseAmount();
        } while (isInvalidPurchaseAmount(purchaseAmount));
    }

    private boolean isInvalidPurchaseAmount(String purchaseAmount) {
        try {
            ValidationUtils.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return true;
        }
        return false;
    }
}
