package controller;

import View.MessagePrinter;

public class LottoController {
    public void start() {
        askLottoPurchaseAmount();
    }

    private void askLottoPurchaseAmount() {
        MessagePrinter.inputAmount();
    }
}
