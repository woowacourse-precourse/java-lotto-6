package lotto.controller;

import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        int purchaseAmount = inputLottoPurchaseAmount();
    }

    private int inputLottoPurchaseAmount() {
        do {
            try {
                int purchaseAmount = InputView.enterLottoPurchaseAmount();
                LottoValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);
    }
}
