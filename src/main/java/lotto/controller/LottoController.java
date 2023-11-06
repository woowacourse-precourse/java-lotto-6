package lotto.controller;

import lotto.error.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
    }

    private int getPurchaseAmount() {
        while (true) {
            outputView.printPurchaseInputMessage();
            try {
                int purchaseAmount = inputView.getNumber();
                if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return purchaseAmount;
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_LOTTO_PURCHASE_AMOUNT);
            }
        }
    }
}
