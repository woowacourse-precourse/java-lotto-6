package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView(new OutputView());
    }

    public void play() {
        receivePurchaseAmount();
    }

    private String receivePurchaseAmount() {
        return inputView.receivePurchaseAmountInput();
    }

}
