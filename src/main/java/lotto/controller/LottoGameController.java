package lotto.controller;

import static lotto.utils.InputException.NOT_DIGIT_FORM;

import lotto.utils.InputException;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameController(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmountFromBuyer();
    }

    private int readPurchaseAmountFromBuyer() {
        outputView.requestPurchaseAmount();
        try {
            return inputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_DIGIT_FORM.getMessage());
            return readPurchaseAmountFromBuyer();
        }
    }
}
