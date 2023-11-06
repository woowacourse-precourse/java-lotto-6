package lotto.controller;

import lotto.view.*;

public class LottoController {
    private String amount;
    private int lottoCnt;

    InputView inputView = new InputView();

    public void playLotto() {
        inputPurchaseAmount();
    }

    public void inputPurchaseAmount() {
        this.amount = inputView.inputAmount();
    }


}
