package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String money = inputView.getPurchaseAmount();
        Amount amount = new Amount(money);
    }
}
